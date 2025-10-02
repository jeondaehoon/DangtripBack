package com.freefit.freefitapp.vo;

import lombok.Data;

import java.util.List;

@Data

public class ArrayDogInfoVO {

    private String userId;
    private String nickName;
    private List<DogInfoVO> dogs;
}
