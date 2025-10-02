package com.freefit.freefitapp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class DogInfoVO {

    private String dogId;
    private String userId;
    private String nickName;
    private String dogName;
    private Integer breedId;
    private Integer dogAge;
    private Double dogWeight;
    private String dogGender;
    private String dogNote;
    private String dogPersonality;
    private String breedName;
    private String hasDog;
}
