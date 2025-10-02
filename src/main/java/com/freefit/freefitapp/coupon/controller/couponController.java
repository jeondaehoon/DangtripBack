package com.freefit.freefitapp.coupon.controller;

import com.freefit.freefitapp.coupon.service.couponService;
import com.freefit.freefitapp.vo.CouponVO;
import com.freefit.freefitapp.vo.UserCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class couponController {
    @Autowired
    private couponService service;

    @GetMapping("/available/{userId}")
    @ResponseBody
    public List<CouponVO> getCoupons(@PathVariable String userId) throws Exception {
        return service.selectCoupons(userId);
    }

    @PostMapping("/issue")
    @ResponseBody
    public boolean issueCoupon(@RequestBody UserCouponVO vo) throws Exception {
        return service.issueCoupon(vo);
    }
}
