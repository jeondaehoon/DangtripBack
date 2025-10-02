package com.freefit.freefitapp.hospital.controller;

import com.freefit.freefitapp.hospital.service.hospitalService;
import com.freefit.freefitapp.vo.HospitalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class hospitalController {
    @Autowired
    private hospitalService service;

    @GetMapping("/hospitals/near")
    @ResponseBody
    public List<HospitalVO> selectNearHospital(@RequestParam double lat, @RequestParam double lon) throws Exception {
        return service.selectNearHospital(lat, lon);
    }

    @GetMapping("/hospitals/popular")
    @ResponseBody
    public List<HospitalVO> selectPopularHospital() throws Exception {
        List<HospitalVO> list = service.selectPopularHospital();
        return list;
    }

    @GetMapping("/hospitals/special")
    @ResponseBody
    public List<HospitalVO> selectSpecialHospital() throws Exception{
        List<HospitalVO> list = service.selectSpecialHospital();
        return list;
    }

    @GetMapping("/hospitals/24hours")
    @ResponseBody
    public List<HospitalVO> select24HoursHospital() throws Exception {
        List<HospitalVO> list = service.select24HoursHospital();
        return list;
    }

    @GetMapping("/hospitals/{id}")
    @ResponseBody
    public HospitalVO selectHospitalDetail(
            @PathVariable("id") int id) throws Exception {
        return service.selectHospitalDetail(id);
    }
}
