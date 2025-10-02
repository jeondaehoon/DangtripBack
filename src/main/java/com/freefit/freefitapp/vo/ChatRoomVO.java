package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class ChatRoomVO {
    private Long roomId;
    private Long groupId;
    private String title;
    private String createdAt;
}
