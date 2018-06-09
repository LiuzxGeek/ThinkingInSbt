package com.springboot.start.controller;

import com.springboot.start.bean.Order;
import com.springboot.start.response.CustomResponse;
import com.springboot.start.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Controller
@EnableAutoConfiguration
public class OrderController {
    @Autowired
    private OrderService mOrderService;

    /**
     * 根据手机号码查询订单
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/order/phone", method = RequestMethod.GET)
    @ResponseBody
    public CustomResponse getOrder(@RequestParam int phone, @RequestParam int page, @RequestParam int size) {
        List<Order> orderList = mOrderService.getOrderByPhone(phone, page, size);
        if (orderList != null) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }

    @PostMapping(value = "/order/insert")
    @ResponseBody
    public CustomResponse insertOrder(@RequestParam String phone, @RequestParam String client_id) {
        Order order = mOrderService.insertOrder(phone, client_id);
        if (order != null && order.getId() != 0) {
            return CustomResponse.success();
        }
        return CustomResponse.empty();
    }
}
