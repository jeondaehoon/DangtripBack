package com.freefit.freefitapp.vo;

import lombok.Data;
import java.util.List;

@Data
public class WalkGroupVO {
    private Long groupId;
    private String title;
    private String description;
    private String location;
    private String detailAddress;
    private String imageUrl;
    private String creatorId;
    private String createdAt;
    private String meetingDays;
    private String meetingTime;
    private int memberCount;
    private String nickname;
    private String role;
    private String notice;

    private List<String> gallery;
    private List<WalkGroupTagVO> tags;
    private List<WalkGroupImageVO> images;
    private List<WalkGroupMemberVO> members;
}
