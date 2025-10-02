package com.freefit.freefitapp.explore.service;

import com.freefit.freefitapp.explore.dao.exploreDao;
import com.freefit.freefitapp.vo.PlaceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class exploreService {
    @Autowired
    exploreDao dao;

    public List<PlaceVO> selectAllPlaces() throws Exception {
        return dao.selectAllPlaces();
    }

    public List<PlaceVO> selectPlacesType(String type) throws Exception {
        return dao.selectPlacesType(type.toUpperCase());
    }
}
