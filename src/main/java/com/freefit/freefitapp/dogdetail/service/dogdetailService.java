package com.freefit.freefitapp.dogdetail.service;

import com.freefit.freefitapp.dogdetail.dao.dogdetailDao;
import com.freefit.freefitapp.vo.DogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dogdetailService {
    @Autowired
    dogdetailDao dao;

    public List<DogInfoVO> selectDogDetail(String dogId) throws Exception{
        return dao.selectDogDetail(dogId);
    }

    public boolean updateDoginfo(DogInfoVO vo) throws Exception {
        return dao.updateDoginfo(vo) > 0;
    }
}
