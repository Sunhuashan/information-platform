package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.User;
import com.shs.bysj.repository.UserRepository;
import com.shs.bysj.service.ILoginService;
import org.apache.shiro.crypto.hash.SimpleHash;
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
    public boolean login(User user) {
        try {
            User userDB = userRepository.findUserByUsername(user.getUsername());
            String salt = userDB.getUserSalt();

            String encodePassDB = userDB.getUserPassword();
            String encodePass = new SimpleHash("md5",user.getUserPassword(),salt,3).toString();

            if (encodePass.equals(encodePassDB))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
