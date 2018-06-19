package com.springboot.start.repository;

import com.springboot.start.bean.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Transactional
    @Query(value = "select phone,client_id from Order t where t.phone =:phone", nativeQuery = false)
    List<Order> findOrderByPhone(@Param("phone") String phone, Pageable pageable);

    /**
     * 根据设备号查询交易记录
     *
     * @param client_id
     * @param pageable
     * @return
     */
    @Query(value = "select t from Order t where t.client_id =?1")
    List<Order> findOrderByDevice(String client_id, Pageable pageable);

    /**
     * 根据电话号码查询订单
     *
     * @param id
     * @return
     */
    @Transactional
    @Query(value = "select phone,client_id from Order t where t.id =:id")
    List<Order> findOrderById(@Param("id") long id);

    /**
     * 查询所有订单
     *
     * @return
     */
    @Transactional
    @Query(value = "select t from Order t ")
    List<Order> findAllOrders();


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "insert into wash_order (phone,client_id,  payment_success,  price,  service_mode, occur_time,  use_coupon) values(?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    int insertOrder(@Param("phone") String phone, @Param("client_id") String client_id, @Param("payment_success") int payment_success, @Param("price") double price, @Param("service_mode") int service_mode, @Param("occur_time") long occur_time, @Param("use_coupon") int use_coupon);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "DELETE * wash_order t (t.id) values(:id)", nativeQuery = true)
    int delOrder(@Param("id") long id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "update Order t set t.phone =:phone, t.client_id=:client_id WHERE t.id=:id")
    int updateOrder(@Param("id") long id, @Param("phone") String phone, @Param("client_id") String client_id);

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    Order save(Order s);
}
