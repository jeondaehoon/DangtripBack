package com.freefit.freefitapp.walks.dao;

import com.freefit.freefitapp.vo.walksVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface walksDao {

    public List<walksVO> selectNearWalks(@Param("lat") double lat, @Param("lon") double lon) throws Exception;

    public List<walksVO> selectPopularWalks() throws Exception ;

    public List<walksVO> selectRecommendWalks() throws Exception ;

    public List<walksVO> selectNightWalks() throws Exception;

    walksVO selectWalkDetail(@Param("id") int id,
                             @Param("lat") double lat,
                             @Param("lon") double lon) throws Exception;

}
