package com.freefit.freefitapp.cafes.dao;

import com.freefit.freefitapp.vo.CafesVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cafesDao {

    public List<CafesVO> selectNearCafe(@Param("lat") double lat, @Param("lon") double lon) throws Exception;

    public List<CafesVO> selectPopularCafe() throws Exception;

    public List<CafesVO> selectRecommendCafe() throws Exception;

    public List<CafesVO> select24hoursCafe() throws Exception;

    CafesVO selectCafeDetail(@Param("id") int id) throws Exception;
}
