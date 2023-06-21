package com.example.sierra.user;

import com.example.sierra.exceptionHandler.BaseException;
import com.example.sierra.exceptionHandler.BaseResponse;
import com.example.sierra.user.model.GetUsersProfileRes;
import com.example.sierra.user.model.PostUsersReq;
import com.example.sierra.user.model.PostUsersRes;
import com.example.sierra.user.model.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/{id}")
    public BaseResponse<GetUsersProfileRes> getUser(@PathVariable("id") int id) {
        try {
            GetUsersProfileRes getUsersProfileRes = userService.getUser(id);

            return new BaseResponse<>(getUsersProfileRes);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public BaseResponse<PostUsersRes> postUser(@Valid @RequestBody PostUsersReq postUsersReq) {
        try {

            PostUsersRes postUsersRes = userService.postUser(postUsersReq);
            return new BaseResponse<>(postUsersRes);
        }catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
