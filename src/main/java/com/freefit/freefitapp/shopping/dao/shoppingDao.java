package com.freefit.freefitapp.shopping.dao;

import com.freefit.freefitapp.vo.CartVO;
import com.freefit.freefitapp.vo.ShoppingVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shoppingDao {

    public List<ShoppingVO> selectCategory() throws Exception;

    public List<ShoppingVO> selectProduct(@Param("categoryId") Integer categoryId) throws Exception;

    public List<ShoppingVO> selectRankings() throws Exception;

    public int addCart(CartVO vo) throws Exception;
}
