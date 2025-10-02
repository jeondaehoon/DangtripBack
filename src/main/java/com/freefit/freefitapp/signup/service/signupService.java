package com.freefit.freefitapp.signup.service;

import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.freefit.freefitapp.signup.dao.signupDao;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class signupService {
    @Autowired
    signupDao dao;

    public boolean checkId(userinfoVO vo) throws Exception {
        return dao.checkId(vo) > 0;
    }

    public boolean signup(userinfoVO vo) throws Exception {
        //비밀번호 암호화
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        vo.setPassword(encoder.encode(vo.getPassword()));
        int save = dao.signup(vo);
        if (save > 0) {
            return true;
        } else {
            return false;
        }
    }
}
