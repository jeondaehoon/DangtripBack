package com.freefit.freefitapp.vo;

import lombok.Data;

import java.util.List;

@Data
public class PostVO {

    private int postId;
    private String userId;
    private String category;
    private String title;
    private String content;
    private String isPrivate;
    private String postPassword = "";
    private String createdAt;
    private String updatedAt;
    private int likeCount;
    private int commentCount;
    private String nickname;
    private String role;

    private List<PostImageVO> images;

}
