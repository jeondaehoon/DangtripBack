package com.freefit.freefitapp.dogdetail.controller;

import com.freefit.freefitapp.dogdetail.service.dogdetailService;
import com.freefit.freefitapp.vo.DogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class dogdetailController {
    @Autowired
    dogdetailService service;

    @GetMapping("/dogdetail/{dogId}")
    @ResponseBody
    public List<DogInfoVO> selectDogDetail(@PathVariable("dogId") String dogId) throws Exception{
        return service.selectDogDetail(dogId);
    }

    @PutMapping("update")
    @ResponseBody
    public boolean updateDoginfo(@RequestBody DogInfoVO vo) throws Exception {
        return service.updateDoginfo(vo);
    }
}
