package com.springboot.start.service;

import com.springboot.start.bean.Order;
import com.springboot.start.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository mOrderRepository;

    /**
     * 根据手机号码查询订单
     *
     * @param phone
     * @return
     */
    public List<Order> getOrderByPhone(String phone, int page, int size) {
        return mOrderRepository.findOrderByPhone(phone, new PageRequest(page, size));
    }

    /**
     * 根据设备id号码查询订单
     *
     * @param id
     * @return
     */
    public List<Order> getOrderByDevice(String id, int page, int size) {
        return mOrderRepository.findOrderByDevice(id, new PageRequest(page, size));
    }

}