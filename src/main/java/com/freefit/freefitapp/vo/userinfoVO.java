package com.freefit.freefitapp.vo;

import lombok.Data;

@Data
public class userinfoVO {

    private String userId;
    private String password;
    private String email;
    private String name;
    private String birth;
    private String carrier;
    private String gender;
    private String nationality;
    private String phone;
    private String address;
    private String addressDetail;
    private String role;
    private String nickname;

    private String currentPassword; // 현재 비밀번호 확인용
    private String newPassword;     // 새 비밀번호 변경용
}
