package com.springboot.start.controller;

import com.springboot.start.bean.Order;
import com.springboot.start.bean.Payment;
import com.springboot.start.response.CustomResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Controller
@RequestMapping(value = "/pay")
public class PayController {
    /**
     * 支付接口（暂时预留）
     *
     * @param payment
     * @return
     */
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseBody
    public CustomResponse<Order> payment(Payment payment) {
        Order orderInfo = new Order(payment);
        orderInfo.setPayment_success(true);
        return new CustomResponse(orderInfo);
    }
}
