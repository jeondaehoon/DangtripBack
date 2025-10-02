package com.freefit.freefitapp.vo;

import lombok.Data;

import java.util.List;

@Data
public class CommentVO {
    private int commentId;
    private int postId;
    private String userId;
    private String content;
    private String createdAt;
    private String nickname;
    private Integer parentId;
    private String postTitle;

    private List<CommentVO> replies;
}
