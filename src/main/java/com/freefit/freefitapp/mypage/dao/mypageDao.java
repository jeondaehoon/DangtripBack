package com.freefit.freefitapp.mypage.dao;

import com.freefit.freefitapp.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mypageDao {

    public userinfoVO selectUser(String userId) throws Exception;

    public List<WalkLogVO> selectWalkLog(String userId) throws Exception;

    public WalkLogVO selectWalkLogDetail(int walkId) throws Exception;

    public List<EmergencyLogVO> selectEmergencyLog(int walkId) throws Exception;

    public List<PostVO> selectPost(String userId) throws Exception;

    public List<CommentVO> selectComment(String userId) throws Exception;

    public List<CouponVO> selectUserCoupon(String userId) throws Exception;

    public userinfoVO selectUserInfo(String userId) throws Exception;

    public String getPassword(@Param("userId") String userId) throws Exception;

    public int updatePassword(@Param("userId") String userId, @Param("newPassword") String newPassword) throws Exception;

    public int updateUserBirth(userinfoVO vo) throws Exception;

    public int updateDogNickname(userinfoVO vo) throws Exception;

    public int updateContact(userinfoVO vo) throws Exception;

    public userinfoVO selectUserAddress(String userId) throws Exception;

    public List<DeliveryAddressVO> selectDeliveryAddress(String userId) throws Exception;

    public int updateUserAddress(userinfoVO vo) throws Exception;

    public int updateDeliveryAddress(DeliveryAddressVO vo) throws Exception;

    public int deleteDeliveryAddress(DeliveryAddressVO vo) throws Exception;

    public int insertDeliveryAddress(DeliveryAddressVO vo) throws Exception;
}
