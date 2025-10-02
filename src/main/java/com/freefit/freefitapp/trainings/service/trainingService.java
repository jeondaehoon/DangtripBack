package com.freefit.freefitapp.trainings.service;

import com.freefit.freefitapp.trainings.dao.trainingDao;
import com.freefit.freefitapp.vo.TrainingsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class trainingService {
    @Autowired
    trainingDao dao;

    public List<TrainingsVO> selectTrainingCategory(String category) throws Exception{
        return dao.selectTrainingCategory(category);
    }

    public TrainingsVO selectTrainingDetail(int id) throws Exception {
        return dao.selectTrainingDetail(id);
    }
}
