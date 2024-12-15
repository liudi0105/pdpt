package com.pd.server.auth.user_info;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UsersDTO {
    private Long id;
    private String username;
}
