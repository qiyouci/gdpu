package com.manage.gdpu.service;

import com.manage.gdpu.entity.User;
import com.manage.gdpu.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 验证用户身份的方法，通过用户名和密码与数据库中的用户记录进行比对
     *
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名和密码匹配返回true，否则返回false
     */
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user!= null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
    public boolean register(String username, String password) {
        // 检查用户名是否已存在
        if (userRepository.findByUsername(username) != null) {
            return false; // 用户名已存在
        }

        // 保存新用户
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return true;
    }
}