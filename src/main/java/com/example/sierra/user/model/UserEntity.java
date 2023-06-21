package com.example.sierra.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter @AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login_id;
    private String passwd;
    private String restapi_key;
    private String regdate;

    // 회원가입 (entity->DTO)
    public PostUsersRes toPostUserRes() {
        return new PostUsersRes(id, restapi_key);
    }
}
