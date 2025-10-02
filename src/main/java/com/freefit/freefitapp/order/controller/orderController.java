package com.freefit.freefitapp.order.controller;

import com.freefit.freefitapp.order.service.orderService;
import com.freefit.freefitapp.vo.DeliveryAddressVO;
import com.freefit.freefitapp.vo.OrdersVO;
import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class orderController {
    @Autowired
    private orderService service;

    @GetMapping("/userinfo/{userId}")
    @ResponseBody
    public userinfoVO selectUserInfo(@PathVariable("userId") String userId) throws Exception{
        return service.selectUserInfo(userId);
    }

    @PostMapping("/delivery")
    @ResponseBody
    public boolean insertAddress(@RequestBody DeliveryAddressVO vo) throws Exception {
        return service.insertAddress(vo);
    }

    @GetMapping("/deliveryinfo/{userId}")
    @ResponseBody
    public List<DeliveryAddressVO> selectDeliveryInfo(@PathVariable("userId") String userId) throws Exception{
        return service.selectDeliveryInfo(userId);
    }

    @PostMapping("/order")
    @ResponseBody
    public boolean insertOrder(@RequestBody OrdersVO vo) throws Exception {
        return service.insertOrder(vo);
    }
}
