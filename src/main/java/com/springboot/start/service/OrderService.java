package com.springboot.start.service;

import com.springboot.start.bean.Order;
import com.springboot.start.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Long> iterable = new ArrayList<>();
        iterable.add(1l);
//        return mOrderRepository.findAllById(iterable);
        return mOrderRepository.findOrderByPhone(phone, PageRequest.of(page, size));
    }

    /**
     * 根据设备id号码查询订单
     *
     * @param client_id
     * @return
     */
    public List<Order> getOrderByDevice(String client_id, int page, int size) {
        return mOrderRepository.findOrderByDevice(client_id, PageRequest.of(page, size));
    }

    /**
     * 根据id查询订单
     *
     * @param id
     * @return
     */
    public List<Order> getOrderById(long id) {
        return mOrderRepository.findOrderById(id);
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    public List<Order> getAllOrder() {
        return mOrderRepository.findAllOrders();
    }

    public Order insertOrder(String phone, String client_id, int payment_success, double price, int service_mode, long time, int use_coupon) {
        //return mOrderRepository.save(order);
        if (mOrderRepository.insertOrder(phone, client_id, payment_success, price, service_mode, time, use_coupon) == 1) {
            return getOrder(phone, client_id);
        }
        return null;
    }

    public boolean delOrder(long id) {
        return mOrderRepository.delOrder(id) == 1;
    }

    public Order updateOrder(long id, String phone, String client_id) {
        if (mOrderRepository.updateOrder(id, phone, client_id) == 1) {
            return getOrder(phone, client_id);
        }
        return null;
    }

    private Order getOrder(String phone, String client_id) {
        Order order = new Order();
        order.setPhone(phone);
        order.setClient_id(client_id);
        return order;
    }

    private Order getOrder(String phone, String client_id, int payment_success, double price, int service_mode, long time, int use_coupon) {
        Order order = new Order();
        order.setPhone(phone);
        order.setClient_id(client_id);
        order.setPayment_success(payment_success == 1);
        order.setPrice(price);
        order.setService_mode(service_mode);
        order.setTime(time);
        order.setUse_coupon(use_coupon == 1);
        return order;
    }
}
