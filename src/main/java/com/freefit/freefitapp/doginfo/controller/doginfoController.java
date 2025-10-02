package com.freefit.freefitapp.doginfo.controller;

import com.freefit.freefitapp.doginfo.service.doginfoService;
import com.freefit.freefitapp.vo.ArrayDogInfoVO;
import com.freefit.freefitapp.vo.CategoryVO;
import com.freefit.freefitapp.vo.DogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class doginfoController {

    @Autowired
    private doginfoService service;

    @GetMapping("/dogbreeds")
    @ResponseBody
    public List<DogInfoVO> selectDogBreed(DogInfoVO vo) throws Exception {
        List<DogInfoVO> list = service.selectDogBreed(vo);
        return list;
    }

    @RequestMapping("/checknickName")
    @ResponseBody
    public boolean checknickName(@RequestBody DogInfoVO vo) throws Exception {
        System.out.println(vo.getNickName());
        return service.checknickName(vo);
    }

    @RequestMapping("/saveDogInfo")
    @ResponseBody
    public boolean saveDogInfo(@RequestBody ArrayDogInfoVO vo) throws Exception {
        System.out.println(vo);
        return service.saveDogInfo(vo);
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<CategoryVO> getAllCategories() throws Exception {
        CategoryVO vo = new CategoryVO();
        return service.selectCatList(vo);
    }
}
