package com.freefit.freefitapp.cafes.controller;

import com.freefit.freefitapp.cafes.service.cafesService;
import com.freefit.freefitapp.vo.CafesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class cafesController {
    @Autowired
    private cafesService service;

    @GetMapping("/cafes/near")
    @ResponseBody
    public List<CafesVO> selectNearCafe(@RequestParam double lat, @RequestParam double lon) throws Exception {
        return service.selectNearCafe(lat, lon);
    }

    @GetMapping("/cafes/popular")
    @ResponseBody
    public List<CafesVO> selectPopularCafe() throws Exception {
        List<CafesVO> list = service.selectPopularCafe();
        return list;
    }

    @GetMapping("/cafes/recommend")
    @ResponseBody
    public List<CafesVO> selectRecommendCafe() throws Exception {
        List<CafesVO> list = service.selectRecommendCafe();
        return list;
    }

    @GetMapping("/cafes/24hours")
    @ResponseBody
    public List<CafesVO> select24hoursCafe() throws Exception {
        List<CafesVO> list = service.select24hoursCafe();
        return list;
    }

    @GetMapping("/cafes/{id}")
    @ResponseBody
    public CafesVO selectCafeDetail(
            @PathVariable("id") int id) throws Exception {
        return service.selectCafeDetail(id);
    }
}
