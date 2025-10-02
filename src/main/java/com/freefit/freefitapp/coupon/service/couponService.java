package com.freefit.freefitapp.coupon.service;

import com.freefit.freefitapp.coupon.dao.couponDao;
import com.freefit.freefitapp.vo.CouponVO;
import com.freefit.freefitapp.vo.UserCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class couponService {
    @Autowired
    couponDao dao;

    public List<CouponVO> selectCoupons(String userId) throws Exception {
        return dao.selectCoupons(userId);
    }

    public boolean issueCoupon(UserCouponVO vo) throws Exception{
        int result = dao.issueCoupon(vo);
        if(result > 0) {
            return true;
        } else {
            return false;
        }
    }
}
