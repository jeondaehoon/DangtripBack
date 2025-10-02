package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class CategoryVO {
    private Integer categoryId;
    private Integer parentId;
    private String name;
    private Integer levelNo;
    private String catLv;
}
