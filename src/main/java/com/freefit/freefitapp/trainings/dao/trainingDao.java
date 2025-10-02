package com.freefit.freefitapp.trainings.dao;

import com.freefit.freefitapp.vo.TrainingsVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface trainingDao {

    public List<TrainingsVO> selectTrainingCategory(@Param("category") String category) throws Exception;

    public TrainingsVO selectTrainingDetail(@Param("id") int id) throws Exception ;
}
