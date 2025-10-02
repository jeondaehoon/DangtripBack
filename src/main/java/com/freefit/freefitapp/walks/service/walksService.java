package com.freefit.freefitapp.walks.service;

import com.freefit.freefitapp.vo.walksVO;
import com.freefit.freefitapp.walks.dao.walksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class walksService {
    @Autowired
    walksDao dao;

    public List<walksVO> selectNearWalks(double lat, double lon) throws Exception{
        return dao.selectNearWalks(lat, lon);
    }

    public List<walksVO> selectPopularWalks() throws Exception {
        return dao.selectPopularWalks();
    }

    public List<walksVO> selectRecommendWalks() throws Exception {
        return dao.selectRecommendWalks();
    }

    public List<walksVO> selectNightWalks() throws Exception {
        return dao.selectNightWalks();
    }
//asd
    public walksVO selectWalkDetail(int id, double lat, double lon) throws Exception{
        return dao.selectWalkDetail(id, lat, lon);
    }
}
