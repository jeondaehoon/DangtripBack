package com.freefit.freefitapp.mypage.controller;

import com.freefit.freefitapp.mypage.service.mypageService;
import com.freefit.freefitapp.vo.*;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class mypageController {
    @Autowired
    private mypageService service;

    @GetMapping("/user/{userId}")
    @ResponseBody
    public userinfoVO getUser(@PathVariable("userId") String userId) throws Exception {
        return service.selectUser(userId);
    }

    @GetMapping("/walklog/{userId}")
    @ResponseBody
    public List<WalkLogVO> getWalkLog(@PathVariable("userId") String userId) throws Exception {
        return service.selectWalkLog(userId);
    }

    @GetMapping("/walklog/detail/{walkId}")
    @ResponseBody
    public WalkLogVO getWalkLogDetail(@PathVariable int walkId) throws Exception {
        return service.selectWalkLogDetail(walkId);
    }

    @GetMapping("/community/myposts/{userId}")
    @ResponseBody
    public List<PostVO> getPosts(@PathVariable String userId) throws Exception {
        return service.selectPost(userId);
    }

    @GetMapping("/community/mycomments/{userId}")
    @ResponseBody
    public List<CommentVO> getComment(@PathVariable String userId) throws Exception {
        return service.selectComment(userId);
    }

    @GetMapping("/mypage/mycoupons/{userId}")
    @ResponseBody
    public List<CouponVO> getUserCoupon(@PathVariable String userId) throws Exception {
        return service.selectUserCoupon(userId);
    }

    @GetMapping("/userdetailinfo/{userId}")
    @ResponseBody
    public userinfoVO getUserInfo(@PathVariable String userId) throws Exception {
        return service.selectUserInfo(userId);
    }

    @PostMapping("/check/password")
    @ResponseBody
    public boolean checkPassword(@RequestParam String userId, @RequestParam String currentPassword) throws Exception{
        return service.checkPassword(userId, currentPassword);
    }

    @PostMapping("/update/password")
    @ResponseBody
    public boolean updatePassword(@RequestParam String userId, @RequestParam String currentPassword, @RequestParam String newPassword) throws Exception {
        return service.updatePassword(userId, currentPassword, newPassword);
    }

    @PostMapping("/update/profile")
    @ResponseBody
    public boolean updateProfile(@RequestBody userinfoVO vo) throws Exception{
        return service.updateProfile(vo);
    }

    @PostMapping("/update/contact")
    @ResponseBody
    public boolean updateContact(@RequestBody userinfoVO vo) throws Exception{
        return service.updateContact(vo);
    }

    @GetMapping("/select/useraddress/{userId}")
    @ResponseBody
    public userinfoVO getUserAddress(@PathVariable("userId") String userId) throws Exception{
        return service.selectUserAddress(userId);
    }

    @GetMapping("/select/deliveryaddress/{userId}")
    @ResponseBody
    public List<DeliveryAddressVO> getDeliveryAddress(@PathVariable("userId") String userId) throws Exception{
        return service.selectDeliveryAddress(userId);
    }

    @PutMapping("/update/useraddress/{userId}")
    @ResponseBody
    public boolean updateUserAddress(@PathVariable("userId") String userId, @RequestBody userinfoVO vo) throws Exception {
        vo.setUserId(userId);
        return service.updateUserAddress(vo);
    }

    @PutMapping("/update/deliveryaddress/{addressId}")
    @ResponseBody
    public boolean updateDeliveryAddress(@PathVariable("addressId") int addressId, @RequestBody DeliveryAddressVO vo) throws Exception {
        vo.setAddressId(addressId);
        return service.updateDeliveryAddress(vo);
    }

    @DeleteMapping("/delete/deliveryaddress/{addressId}")
    @ResponseBody
    public boolean deleteDeliveryAddress(@PathVariable("addressId") int addressId) throws Exception {
        DeliveryAddressVO vo = new DeliveryAddressVO();
        vo.setAddressId(addressId);
        return service.deleteDeliveryAddress(vo);
    }


    @PostMapping("/insert/deliveryaddress")
    @ResponseBody
    public boolean insertDeliveryAddress(@RequestBody DeliveryAddressVO vo) throws Exception {
        return service.insertDeliveryAddress(vo);
    }
}
