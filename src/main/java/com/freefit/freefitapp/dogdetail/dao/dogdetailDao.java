package com.freefit.freefitapp.dogdetail.dao;

import com.freefit.freefitapp.vo.DogInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dogdetailDao {

    List<DogInfoVO> selectDogDetail(@Param("dogId") String dogId) throws Exception;

    int updateDoginfo(DogInfoVO vo) throws Exception;
}
