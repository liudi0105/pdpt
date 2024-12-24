package com.pt.server.auth.users.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class PersonalInfoVO {
    private Double bambooShootAmount;
    private Double inviteAmount;
    private Double medalAmount;
    private Double shareRatio;
    private Double hitAndRunAmount;
    private Long uploadSize;
    private Long downloadSize;
    private Long currentDownloadAmount;
    private Long currentUploadAmount;
    private Long seedScore;
}
