package com.freefit.freefitapp.login.dao;

import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.stereotype.Repository;

@Repository
public interface loginDao {

    String getPasswordByUserId(String userId) throws Exception;

}
