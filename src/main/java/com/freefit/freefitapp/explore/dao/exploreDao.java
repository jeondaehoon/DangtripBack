package com.freefit.freefitapp.explore.dao;

import com.freefit.freefitapp.vo.PlaceVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface exploreDao {

    public List<PlaceVO> selectAllPlaces() throws Exception;

    public List<PlaceVO> selectPlacesType(@Param("type") String type) throws Exception;
}
