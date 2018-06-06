package com.springboot.start.repository;

import com.springboot.start.bean.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into User t (t.nickname,t.gender) values(:nickname,:gender)", nativeQuery = true)
    boolean insertUser(@Param("nickname") String nickname, @Param("gender") String gender);

    @Query(value = "select t from User t where t.id=:id")
    User findOne(@Param("id") long id);

}
