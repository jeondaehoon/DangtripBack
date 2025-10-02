package com.freefit.freefitapp.main.dao;

import com.freefit.freefitapp.vo.DogInfoVO;
import com.freefit.freefitapp.vo.PromotionVO;
import com.freefit.freefitapp.vo.walksVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mainDao {

    String selectNickname(@Param("userId") String userId) throws Exception;

    public List<DogInfoVO> selectDoginfo(@Param("userId") String userId) throws Exception;

    public List<PromotionVO> selectPromotion() throws Exception;

    public List<walksVO> selectWalks(@Param("lat") double lat, @Param("lon") double lon) throws Exception;
}
