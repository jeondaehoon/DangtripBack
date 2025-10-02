package com.freefit.freefitapp.order.dao;

import com.freefit.freefitapp.vo.DeliveryAddressVO;
import com.freefit.freefitapp.vo.OrderItemsVO;
import com.freefit.freefitapp.vo.OrdersVO;
import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderDao {

    public userinfoVO selectUserInfo(String userId) throws Exception;

    public int insertAddress(DeliveryAddressVO vo) throws Exception ;

    public List<DeliveryAddressVO> selectDeliveryInfo(String userId) throws Exception;

    public int insertOrder(OrdersVO vo) throws Exception;

    public int insertOrderItem(OrderItemsVO vo) throws Exception;

    public int deleteCartUserId(String userId) throws Exception;
}
