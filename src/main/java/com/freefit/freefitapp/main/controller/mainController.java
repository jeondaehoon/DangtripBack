package com.freefit.freefitapp.main.controller;

import com.freefit.freefitapp.main.service.mainService;
import com.freefit.freefitapp.vo.DogInfoVO;
import com.freefit.freefitapp.vo.PromotionVO;
import com.freefit.freefitapp.vo.walksVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class mainController {
    @Autowired
    private mainService service;

    @GetMapping("/nickname/{userId}")
    @ResponseBody
    public String selectNickname(@PathVariable("userId") String userId) throws Exception{
        return service.selectNickname(userId);
    }

    @GetMapping("/doginfo/{userId}")
    @ResponseBody
    public List<DogInfoVO> selectDoginfo(@PathVariable("userId") String userId) throws Exception{
        List<DogInfoVO> list = service.selectDoginfo(userId);
        return list;
    }

    @GetMapping("/promos")
    @ResponseBody
    public List<PromotionVO> selectPromotion() throws Exception {
        List<PromotionVO> list = service.selectPromotion();
        return list;
    }

    @GetMapping("/walks")
    @ResponseBody
    public List<walksVO> selectWalks(@RequestParam double lat, @RequestParam double lon) throws Exception{
        List<walksVO> result = service.selectWalks(lat, lon);
        return result;
    }

}
