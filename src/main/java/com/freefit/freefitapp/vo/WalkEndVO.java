package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class WalkEndVO {
    private String userId;
    private String startTime;
    private String endTime;
    private int duration;
    private EmergencyLogVO emergency;
}
