package com.freefit.freefitapp.cart.service;

import com.freefit.freefitapp.cart.dao.cartDao;
import com.freefit.freefitapp.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartService {
    @Autowired
    cartDao dao;

    public List<CartVO> selectCart(String userId) throws Exception {
        return dao.selectCart(userId);
    }

    public boolean updateCart(CartVO vo) throws Exception {
        return dao.updateCart(vo) > 0;
    }

    public boolean deleteCart(int cartId) throws Exception {
        return dao.deleteCart(cartId) > 0;
    }
}
