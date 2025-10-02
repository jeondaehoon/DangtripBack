package com.freefit.freefitapp.explore.controller;

import com.freefit.freefitapp.explore.service.exploreService;
import com.freefit.freefitapp.vo.PlaceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class exploreController {
    @Autowired
    private exploreService service;

    @GetMapping("/explore/places")
    @ResponseBody
    public List<PlaceVO> getAllPlaces() throws Exception {
        return service.selectAllPlaces();
    }

    @GetMapping("/explore/places/{type}")
    @ResponseBody
    public List<PlaceVO> getPlacesType(@PathVariable("type") String type) throws Exception{
        return service.selectPlacesType(type);
    }
}
