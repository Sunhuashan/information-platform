package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.User;
import com.shs.bysj.repository.UserRepository;
import com.shs.bysj.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

/**
 * @Author: shs
 * @Data: 2022/4/21 10:56
 */
@Service
public class LoginService implements ILoginService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void login(User user) {

    }
}
