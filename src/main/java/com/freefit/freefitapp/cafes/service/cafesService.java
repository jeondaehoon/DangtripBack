package com.freefit.freefitapp.cafes.service;

import com.freefit.freefitapp.cafes.dao.cafesDao;
import com.freefit.freefitapp.vo.CafesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cafesService {
    @Autowired
    cafesDao dao;

    public List<CafesVO> selectNearCafe(double lat, double lon) throws Exception {
        return dao.selectNearCafe(lat, lon);
    }

    public List<CafesVO> selectPopularCafe() throws Exception {
        return dao.selectPopularCafe();
    }

    public List<CafesVO> selectRecommendCafe() throws Exception {
        return dao.selectRecommendCafe();
    }

    public List<CafesVO> select24hoursCafe() throws Exception {
        return dao.select24hoursCafe();
    }

    public CafesVO selectCafeDetail(int id) throws Exception {
        return dao.selectCafeDetail(id);
    }
}
