package com.freefit.freefitapp.trainings.controller;

import com.freefit.freefitapp.trainings.service.trainingService;
import com.freefit.freefitapp.vo.TrainingsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class trainingController {
    @Autowired
    private trainingService service;

    @GetMapping("/trainings")
    @ResponseBody
    public List<TrainingsVO> selectTrainingCategory(
            @RequestParam(value = "category", required = false) String category) throws Exception {
        return service.selectTrainingCategory(category);
    }

    @GetMapping("/trainingdetail/{id}")
    @ResponseBody
    public TrainingsVO selectTrainingDetail(@PathVariable("id") int id) throws Exception{
        return service.selectTrainingDetail(id);
    }
}
