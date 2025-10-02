package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkGroupTagVO {
    private Long tagId;
    private Long groupId;
    private String tagName;
    private String iconName;

    public WalkGroupTagVO(String tagName) {
        this.tagName = tagName;
    }

    public WalkGroupTagVO() {}
}
