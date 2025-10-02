package com.freefit.freefitapp.login.service;

import com.freefit.freefitapp.login.dao.loginDao;
import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    @Autowired
    loginDao dao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean loginGetToken(userinfoVO vo) throws Exception {
        //DB에서 해당의 아이디 암호화된 비밀번호 가져오기
        String encodePassword = dao.getPasswordByUserId(vo.getUserId());

        //실패로직
        if(encodePassword == null) {
            return false;
        }

        // 암호화 비밀번호 비교하기
        return passwordEncoder.matches(vo.getPassword(), encodePassword);
    }
}
