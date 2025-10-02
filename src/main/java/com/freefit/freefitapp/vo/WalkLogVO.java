package com.freefit.freefitapp.vo;

import lombok.Data;

import java.util.List;

@Data
public class WalkLogVO {
    private int walkId;
    private String userId;
    private String startTime;
    private String endTime;
    private int duration;
    private String createdAt;
    private List<EmergencyLogVO> emergency;
}
