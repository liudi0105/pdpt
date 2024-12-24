package com.pt.server.auth.users;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    @Getter
    private UsersRepo usersRepo;
}
