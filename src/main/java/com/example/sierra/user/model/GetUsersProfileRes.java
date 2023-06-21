package com.example.sierra.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUsersProfileRes {
    private Integer id;
    private String login_id;
    private String passwd;
    private String restapi_key;
    private String regdate;
}
