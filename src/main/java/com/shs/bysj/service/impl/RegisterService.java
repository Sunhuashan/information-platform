package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.User;
import com.shs.bysj.repository.UserRepository;
import com.shs.bysj.service.IRegisterService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: shs
 * @Data: 2022/4/22 11:31
 */
@Service
public class RegisterService implements IRegisterService {
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean isExist(User user) {
        User userDB = userRepository.findUserByUsername(user.getUsername());
        if (userDB == null)
            return false;
        return true;
    }

    @Override
    public void addUser(User user) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodePassword = new SimpleHash("md5", user.getUserPassword(), salt, 3).toString();
        user.setUserSalt(salt);
        user.setUserPassword(encodePassword);
        userRepository.save(user);
    }
}
