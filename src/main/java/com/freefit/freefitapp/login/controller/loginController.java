package com.freefit.freefitapp.login.controller;

import com.freefit.freefitapp.login.service.loginService;
import com.freefit.freefitapp.util.JwtUtil;
import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    loginService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(@RequestBody userinfoVO vo) throws Exception {
        Map<String, String> result = new HashMap<>();

        boolean loginSuccess = service.loginGetToken(vo);

        if (loginSuccess) {
            String token = jwtUtil.generateToken(vo.getUserId());
            result.put("token", token);
            result.put("message", "로그인 성공");
        } else {
            result.put("message", "아이디 또는 비밀번호 오류");
        }
        return result;
    }
}
