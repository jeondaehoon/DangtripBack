package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkGroupNoticeVO {
    private Long noticeId;
    private Long groupId;
    private String content;
    private String createdAt;
    private String createdBy;
}
