package com.freefit.freefitapp.order.service;

import com.freefit.freefitapp.order.dao.orderDao;
import com.freefit.freefitapp.vo.DeliveryAddressVO;
import com.freefit.freefitapp.vo.OrderItemsVO;
import com.freefit.freefitapp.vo.OrdersVO;
import com.freefit.freefitapp.vo.userinfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    orderDao dao;

    public userinfoVO selectUserInfo(String userId) throws Exception {
        return dao.selectUserInfo(userId);
    }

    public boolean insertAddress(DeliveryAddressVO vo) throws Exception {
        return dao.insertAddress(vo) > 0;
    }

    public List<DeliveryAddressVO> selectDeliveryInfo(String userId) throws Exception{
        return dao.selectDeliveryInfo(userId);
    }

    public boolean insertOrder(OrdersVO vo) throws Exception {
        int result = dao.insertOrder(vo);
        if(result <= 0) return false;

        int orderId = vo.getOrderId();
        if (orderId == 0) {
            throw new RuntimeException("orderId 생성 실패");
        }

        if (vo.getItems() != null) {
            for(OrderItemsVO item : vo.getItems()) {
                item.setOrderId(orderId);
                dao.insertOrderItem(item);
            }
        }
        dao.deleteCartUserId(vo.getUserId());
        return true;
    }

}
