package com.freefit.freefitapp.main.service;

import com.freefit.freefitapp.main.dao.mainDao;
import com.freefit.freefitapp.vo.DogInfoVO;
import com.freefit.freefitapp.vo.PromotionVO;
import com.freefit.freefitapp.vo.walksVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mainService {
    @Autowired
    mainDao dao;

    public String selectNickname(String userId) throws Exception{
        return dao.selectNickname(userId);
    }

    public List<DogInfoVO> selectDoginfo(String userId) throws Exception{
        return dao.selectDoginfo(userId);
    }

    public List<PromotionVO> selectPromotion() throws Exception{
        return dao.selectPromotion();
    }

    public List<walksVO> selectWalks(double lat, double lon) throws Exception{
        return dao.selectWalks(lat, lon);
    }
}
