package com.freefit.freefitapp.cart.dao;

import com.freefit.freefitapp.vo.CartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cartDao {

    public List<CartVO> selectCart(String userId) throws Exception;

    public int updateCart(CartVO vo) throws Exception;

    public int deleteCart(int cartId) throws Exception;
}
