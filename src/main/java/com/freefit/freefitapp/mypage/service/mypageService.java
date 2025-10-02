package com.freefit.freefitapp.mypage.service;

import com.freefit.freefitapp.mypage.dao.mypageDao;
import com.freefit.freefitapp.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class mypageService {
    @Autowired
    mypageDao dao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public userinfoVO selectUser(String userId) throws Exception{
        return dao.selectUser(userId);
    }

    public List<WalkLogVO> selectWalkLog(String userId) throws Exception {
        return dao.selectWalkLog(userId);
    }

    public WalkLogVO selectWalkLogDetail(int walkId) throws Exception {
        WalkLogVO walk = dao.selectWalkLogDetail(walkId);
        List<EmergencyLogVO> emergency = dao.selectEmergencyLog(walkId);
        walk.setEmergency(emergency);
        return walk;
    }

    public List<PostVO> selectPost(String userId) throws Exception {
        return dao.selectPost(userId);
    }

    public List<CommentVO> selectComment(String userId) throws Exception {
        return dao.selectComment(userId);
    }

    public List<CouponVO> selectUserCoupon(String userId) throws Exception {
        return dao.selectUserCoupon(userId);
    }

    public userinfoVO selectUserInfo(String userId) throws Exception {
        return dao.selectUserInfo(userId);
    }

    public boolean checkPassword(String userId, String currentPassword) throws Exception{
        String password = dao.getPassword(userId);
        if(password == null) {
            return false;
        }
        return passwordEncoder.matches(currentPassword, password);
    }

    public boolean updatePassword(String userId, String currentPassword, String newPassword) throws Exception{
        String pw = dao.getPassword(userId);

        if (pw == null) {
            return false;
        }
        //현재 비밀번호랑 불일치하게하기
        if (!passwordEncoder.matches(currentPassword, pw)) {
            return false;
        }
        // 새비밀번호 == 현재 비밀번호
        if (passwordEncoder.matches(newPassword, pw)) {
            return false;
        }

        // 새비밀먼호 함호화루 업데티트
        String newpw = passwordEncoder.encode(newPassword);
        dao.updatePassword(userId, newpw);

        return true;
    }

    public boolean updateProfile(userinfoVO vo) throws Exception {
        int user = dao.updateUserBirth(vo);
        int dog = dao.updateDogNickname(vo);
        return user > 0 && dog > 0;
    }

    public boolean updateContact(userinfoVO vo) throws Exception {
        int contact = dao.updateContact(vo);
        return contact > 0;
    }

    public userinfoVO selectUserAddress(String userId) throws Exception{
        return dao.selectUserAddress(userId);
    }

    public List<DeliveryAddressVO> selectDeliveryAddress(String userId) throws Exception {
        return dao.selectDeliveryAddress(userId);
    }

    public boolean updateUserAddress(userinfoVO vo) throws Exception {
        int address = dao.updateUserAddress(vo);
        return address > 0 ;
    }

    public boolean updateDeliveryAddress(DeliveryAddressVO vo) throws Exception {
        int address = dao.updateDeliveryAddress(vo);
        return address > 0;
    }

    public boolean deleteDeliveryAddress(DeliveryAddressVO vo) throws Exception {
        int delete = dao.deleteDeliveryAddress(vo);
        return delete > 0;
    }

    public boolean insertDeliveryAddress(DeliveryAddressVO vo) throws Exception {
        int insert = dao.insertDeliveryAddress(vo);
        return insert > 0;
    }
}
