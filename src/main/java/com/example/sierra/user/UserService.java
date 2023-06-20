package com.example.sierra.user;

import com.example.sierra.exceptionHandler.BaseException;
import com.example.sierra.user.model.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.example.sierra.exceptionHandler.BaseResponseStatus.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> getUsers() throws BaseException{
        try {
            return userRepository.findAll();
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
