package com.freefit.freefitapp.signup.controller;

import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.freefit.freefitapp.signup.service.signupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class signupController {
    @Autowired
    private signupService service;

    @PostMapping("/checkid")
    @ResponseBody
    public boolean checkId(@RequestBody userinfoVO vo) throws Exception {
        return service.checkId(vo);
    }

    @PostMapping("/signup")
    @ResponseBody
    public boolean signup(@RequestBody userinfoVO vo) throws Exception {
        return service.signup(vo);
    }
}

