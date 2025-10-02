package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class EmergencyVO {
    private int symptom_id;
    private String name;
    private String severity;
    private String action_guide;
    private String description;
}
