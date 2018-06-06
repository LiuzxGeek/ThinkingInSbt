package com.springboot.start.repository;

import com.springboot.start.bean.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * 根据电话号码查询订单
     *
     * @param phone
     * @param pageable
     * @return
     */
    @Async
    @Query(value = "select t.phone from Order t where t.phone =?1")
    List<Order> findOrderByPhone(String phone, Pageable pageable);

    /**
     * 根据设备号查询交易记录
     *
     * @param phone
     * @param pageable
     * @return
     */
    @Query(value = "select t from Order t where t.client_id =?1")
    List<Order> findOrderByDevice(String phone, Pageable pageable);

}
