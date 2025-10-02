package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class EmergencyLogVO {
    private int logId;
    private int walkId;
    private String symptomName;
    private String severity;
    private String description;
    private String actionGuide;
    private String recordedAt;
}
