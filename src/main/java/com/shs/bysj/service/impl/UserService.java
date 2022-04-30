package com.shs.bysj.service.impl;

import com.shs.bysj.pojo.User;
import com.shs.bysj.repository.UserRepository;
import com.shs.bysj.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
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

    @Override
    public User findUserByName(User user) {
        return userRepository.findUserByUsername(user.getUsername());
    }

    @Override
    public boolean checkPassword(User user) {
        User userDB = userRepository.findUserByUsername(user.getUsername());
        String salt = userDB.getUserSalt();

        String encodePassDB = userDB.getUserPassword();
        String encodePass = new SimpleHash("md5", user.getUserPassword(), salt, 3).toString();


        if (encodePass.equals(encodePassDB))
            return true;
        return false;
    }

    @Override
    public void setNewPassword(User user) {
        User userDB = userRepository.findUserByUsername(user.getUsername());
        String salt = userDB.getUserSalt();
        String encodePass = new SimpleHash("md5", user.getNewPassword(), salt, 3).toString();
        userDB.setUserPassword(encodePass);
        userRepository.save(userDB);
    }

    @Override
    public void updateUser(User user) {
        User userDB = userRepository.findUserById(user.getId());

        user.setUserSalt(userDB.getUserSalt());
        user.setUserPassword(userDB.getUserPassword());

        userRepository.save(user);
    }
}
