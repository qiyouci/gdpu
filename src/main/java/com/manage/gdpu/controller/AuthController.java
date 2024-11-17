package com.manage.gdpu.controller;

import com.manage.gdpu.service.AuthService;
import com.manage.gdpu.vo.LoginVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 用户登录接口
     *
     * @param loginVO 包含用户名和密码的登录信息对象
     * @return 登录成功返回状态码200及提示信息，登录失败返回相应错误提示及对应状态码
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginVO loginVO) {
        boolean result = authService.authenticate(loginVO.getUsername(), loginVO.getPassword());
        if (result) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.status(401).body("登录失败，用户名或密码错误");
        }
    }
    /**
     * 用户注册接口
     *
     * @param loginVO 包含用户名和密码的注册信息对象
     * @return 注册成功返回状态码200及提示信息，注册失败返回相应错误提示及对应状态码
     */
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:8082")
    public ResponseEntity<String> register(@RequestBody LoginVO loginVO) {
        boolean result = authService.register(loginVO.getUsername(), loginVO.getPassword());
        if (result) {
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.status(400).body("注册失败，用户名已存在或参数无效");
        }
    }
}