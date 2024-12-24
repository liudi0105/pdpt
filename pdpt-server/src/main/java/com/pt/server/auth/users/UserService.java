package com.pt.server.auth.users;

import com.pt.server.auth.users.vo.PersonalInfoVO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    @Getter
    private UsersRepo usersRepo;

    public PersonalInfoVO personalInfo(Long userId) {
        UsersPO eq = usersRepo.getPoEq(UsersPO::getId, userId);
        return new PersonalInfoVO()
                .setUploadSize(eq.getUploaded())
                .setDownloadSize(eq.getDownloaded())
                ;
    }
}
