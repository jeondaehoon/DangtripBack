package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class ChatMemberVO {
    private Long memberId;
    private Long roomId;
    private String userId;
    private String joinedAt;
}
