package com.example.sierra.user;

import com.example.sierra.exceptionHandler.BaseException;
import com.example.sierra.exceptionHandler.BaseResponse;
import com.example.sierra.user.model.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/")
    public BaseResponse<String> getUsers() {
        try {
            userService.getUsers();
            String result = "성공";
            return new BaseResponse<>(result);
        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
