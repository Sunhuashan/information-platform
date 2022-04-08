package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.User;
import com.shs.bysj.repository.UserRepository;
import com.shs.bysj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/4/6 12:51
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByUsername(String name) {
        userRepository.deleteUserByUsername(name);
    }
}
