package com.freefit.freefitapp.walks.controller;

import com.freefit.freefitapp.vo.walksVO;
import com.freefit.freefitapp.walks.service.walksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class walksController {
    @Autowired
    private walksService service;

    @GetMapping("/walks/near")
    @ResponseBody
    public List<walksVO> selectNearWalks(@RequestParam double lat, @RequestParam double lon) throws Exception{
        return service.selectNearWalks(lat, lon);
    }

    @GetMapping("/walks/popular")
    @ResponseBody
    public List<walksVO> selectPopularWalks() throws Exception {
        List<walksVO> list = service.selectPopularWalks();
        return list;
    }
    
    @GetMapping("/walks/recommend")
    @ResponseBody
    public List<walksVO> selectRecommendWalks() throws Exception {
        return service.selectRecommendWalks();
    }

    @GetMapping("/walks/night")
    @ResponseBody
    public List<walksVO> selectNightWalks() throws Exception{
        return service.selectNightWalks();
    }

    @GetMapping("/walks/{id}")
    @ResponseBody
    public walksVO selectWalkDetail(
            @PathVariable("id") int id,
            @RequestParam("lat") double lat,
            @RequestParam("lon") double lon
    ) throws Exception {
        return service.selectWalkDetail(id, lat, lon);
    }
}
