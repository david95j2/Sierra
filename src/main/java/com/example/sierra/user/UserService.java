package com.example.sierra.user;

import com.example.sierra.exceptionHandler.BaseException;
import com.example.sierra.user.model.GetUsersProfileRes;
import com.example.sierra.user.model.PostUsersReq;
import com.example.sierra.user.model.PostUsersRes;
import com.example.sierra.user.model.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.sierra.exceptionHandler.BaseResponseStatus.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private String creatDate() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date ());
    }
    private String createRestAPIKey() {
        return RandomStringUtils.randomAlphanumeric(15);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GetUsersProfileRes getUser(int id) throws BaseException{
        GetUsersProfileRes getUsersProfileRes;
        try {
            UserEntity user = userRepository.findById(id).get();
            Integer idx = user.getId();
            String login_id = user.getLogin_id();
            String passwd = user.getPasswd();
            String restapi_key = user.getRestapi_key();
            String regdate = user.getRegdate();

            getUsersProfileRes = new GetUsersProfileRes(id, login_id, passwd, restapi_key, regdate);
            return getUsersProfileRes;

        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public PostUsersRes postUser(PostUsersReq postUsersReq) throws BaseException{
        try {
            postUsersReq.setRestapi_key(createRestAPIKey());
            postUsersReq.setRegdate(creatDate());
            UserEntity userEntity = postUsersReq.toEntity();
            userRepository.save(userEntity);
            return userEntity.toPostUserRes();
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
