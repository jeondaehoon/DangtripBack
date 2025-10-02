package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class ChatMessageVO {
    private Long messageId;
    private Long roomId;
    private String userId;
    private String content;
    private String createdAt;
}
