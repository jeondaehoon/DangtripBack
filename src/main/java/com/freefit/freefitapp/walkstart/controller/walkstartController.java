package com.freefit.freefitapp.walkstart.controller;

import com.freefit.freefitapp.vo.EmergencyVO;
import com.freefit.freefitapp.vo.WalkEndVO;
import com.freefit.freefitapp.vo.WalkLogVO;
import com.freefit.freefitapp.walkstart.service.walkstartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class walkstartController {
    @Autowired
    private walkstartService service;

    @GetMapping("/emergency")
    @ResponseBody
    public List<EmergencyVO> getEmergencyList() throws Exception {
        return service.selectEmergencyList();
    }

    @PostMapping("/walk/end")
    @ResponseBody
    public Map<String, Object> endWalk(@RequestBody WalkEndVO vo) throws Exception {
        int walkId = service.endWalk(vo);

        Map<String, Object> result = new HashMap<>();
        result.put("success", walkId > 0);
        result.put("walkId", walkId);
        return result;
    }
}
