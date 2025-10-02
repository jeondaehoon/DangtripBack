package com.freefit.freefitapp.signup.dao;

import com.freefit.freefitapp.vo.userinfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface signupDao {

    public int checkId(userinfoVO vo) throws Exception;

    public int signup(userinfoVO vo) throws Exception;
}
