package com.springboot.start.controller;

import com.springboot.start.bean.Order;
import com.springboot.start.response.CustomResponse;
import com.springboot.start.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public CustomResponse getOrderByPhone(@RequestParam(value = "page, size") String phone, int pageNumber, int pageSize) {
        List<Order> orderList = mOrderService.getOrderByPhone(phone, pageNumber, pageSize);
        if (orderList != null) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }
}
