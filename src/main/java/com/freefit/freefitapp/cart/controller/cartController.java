package com.freefit.freefitapp.cart.controller;

import com.freefit.freefitapp.cart.service.cartService;
import com.freefit.freefitapp.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class cartController {
    @Autowired
    private cartService service;

    @GetMapping("/cart/{userId}")
    @ResponseBody
    public List<CartVO> selectCart(@PathVariable("userId") String userId) throws Exception{
        return service.selectCart(userId);
    }

    @PutMapping("/cartupdate/{cartId}")
    @ResponseBody
    public String updateCart(@PathVariable("cartId") int cartId, @RequestBody CartVO vo) throws Exception {
        vo.setCartId(cartId);
        return service.updateCart(vo) ? "수량 변경 성공" : "수량 변경 실패";
    }

    @DeleteMapping("/cartdelete/{cartId}")
    @ResponseBody
    public String deleteCart(@PathVariable("cartId") int cartId) throws Exception {
        return service.deleteCart(cartId) ? "삭제 성공" : "삭제 실패";
    }
}
