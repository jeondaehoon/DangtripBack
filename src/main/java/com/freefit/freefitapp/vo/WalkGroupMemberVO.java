package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkGroupMemberVO {
    private Long memberId;
    private Long groupId;
    private String userId;
    private String nickname;
    private String role;
    private String joinedAt;
}
