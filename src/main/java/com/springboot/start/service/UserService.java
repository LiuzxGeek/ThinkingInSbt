package com.springboot.start.service;

import com.springboot.start.bean.User;
import com.springboot.start.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Service
public class UserService {
    @Autowired
    private UserRepository mUserRepository;

    public User findOne(long id) {
        return mUserRepository.findOne(id);
    }
}
