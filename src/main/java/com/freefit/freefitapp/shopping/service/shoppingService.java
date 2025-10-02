package com.freefit.freefitapp.shopping.service;

import com.freefit.freefitapp.shopping.dao.shoppingDao;
import com.freefit.freefitapp.vo.CartVO;
import com.freefit.freefitapp.vo.ShoppingVO;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shoppingService {
    @Autowired
    shoppingDao dao;

    public List<ShoppingVO> selectCategory() throws Exception {
        return dao.selectCategory();
    }

    public List<ShoppingVO> selectProduct(Integer categoryId) throws Exception {
        return dao.selectProduct(categoryId);
    }

    public List<ShoppingVO> selectRankings() throws Exception{
        return dao.selectRankings();
    }

    public boolean addCart(CartVO vo) throws Exception {
        return dao.addCart(vo) > 0;
    }
}
