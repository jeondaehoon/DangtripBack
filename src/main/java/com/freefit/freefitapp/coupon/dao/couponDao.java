package com.freefit.freefitapp.coupon.dao;

import com.freefit.freefitapp.vo.CouponVO;
import com.freefit.freefitapp.vo.UserCouponVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface couponDao {

    public List<CouponVO> selectCoupons(@Param("userId") String userId) throws Exception;

    public int issueCoupon(UserCouponVO vo) throws Exception;
}
