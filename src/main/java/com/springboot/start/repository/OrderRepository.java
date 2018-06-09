package com.springboot.start.repository;

import com.springboot.start.bean.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
    @Query(value = "select t from Order t where t.phone =?1")
    List<Order> findOrderByPhone(int phone, Pageable pageable);

    /**
     * 根据设备号查询交易记录
     *
     * @param phone
     * @param pageable
     * @return
     */
    @Query(value = "select t from Order t where t.client_id =?1")
    List<Order> findOrderByDevice(String phone, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "insert into Order t (t.phone,t.client_id) values(:phone,:client_id)", nativeQuery = true)
    boolean insertOrder(@Param("phone") String phone, @Param("client_id") String client_id);


    @Override
    Order save(Order s);
}
