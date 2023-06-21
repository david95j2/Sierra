package com.example.sierra.user.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUsersReq {
    private Integer id;
    @NotEmpty(message = "아이디는 필수 입력값입니다.")
    @Size(min = 3, max = 25)
    private String login_id;
    @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String passwd;
//    @NotEmpty(message = "비밀번호확인은 필수 입력값입니다.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호가 일치하지 않습니다.")
//    private String confirmPassword;

    private String restapi_key;
    private String regdate;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .login_id(login_id)
                .passwd(passwd)
                .restapi_key(restapi_key)
                .regdate(regdate).build();
    }
}
