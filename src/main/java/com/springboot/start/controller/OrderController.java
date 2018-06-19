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
import java.util.logging.Logger;

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
    public CustomResponse getOrder(@RequestParam String phone, @RequestParam int page, @RequestParam int size) {
        List<Order> orderList = mOrderService.getOrderByPhone(phone, page, size);
        if (orderList != null && orderList.size() > 0) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }

    /**
     * 根据机器id查询订单
     *
     * @param client_id
     * @return
     */
    @RequestMapping(value = "/order/device", method = RequestMethod.GET)
    @ResponseBody
    public CustomResponse getOrderByDevice(@RequestParam String client_id, @RequestParam int page, @RequestParam int size) {
        List<Order> orderList = mOrderService.getOrderByDevice(client_id, page, size);
        if (orderList != null && orderList.size() > 0) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }

    /**
     * 根据id查询订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/id", method = RequestMethod.GET)
    @ResponseBody
    public CustomResponse getOrderById(@RequestParam long id) {
        List<Order> orderList = mOrderService.getOrderById(id);
        if (orderList != null) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }

    /**
     * 所有订单
     *
     * @return
     */
    @RequestMapping(value = "/order/all", method = RequestMethod.GET)
    @ResponseBody
    public CustomResponse getAllOrder() {
        List<Order> orderList = mOrderService.getAllOrder();
        if (orderList != null) {
            return new CustomResponse(orderList);
        }
        return CustomResponse.empty();
    }

    @PostMapping(value = "/order/insert")
    @ResponseBody
    public CustomResponse insertOrder(@RequestParam String phone, @RequestParam String client_id, int payment_success, double price, int service_mode, long time, int use_coupon) {
        Order order = mOrderService.insertOrder(phone, client_id, payment_success, price, service_mode, time, use_coupon);
        if (order != null) {
            return CustomResponse.success();
        }
        return CustomResponse.empty();
    }

    @PostMapping(value = "/order/update")
    @ResponseBody
    public CustomResponse updateOrder(@RequestParam long id, @RequestParam String client_id, @RequestParam String phone) {
        if (mOrderService.updateOrder(id, phone, client_id) != null) {
            return CustomResponse.success();
        }
        return CustomResponse.empty();
    }

    @PostMapping(value = "/order/del")
    @ResponseBody
    public CustomResponse delOrder(@RequestParam long id) {
        if (mOrderService.delOrder(id)) {
            return CustomResponse.success();
        }
        return CustomResponse.empty();
    }
}
