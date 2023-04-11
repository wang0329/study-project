package com.example.controller;

import com.example.entity.RestBean;
import com.example.service.AuthorizeService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    private final String EMAIL_REGEX ="^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$";

    @Resource
    AuthorizeService service;

    @PostMapping("/valid-email")
    public RestBean<String> validateEmail(@Pattern(regexp = EMAIL_REGEX) @RequestParam("email")String email){

        if(service.sendValidateEmail(email)){
            return RestBean.success("邮件发送成功");
        }else{
            return RestBean.failure(400,"邮件发送失败");
        }
    }
}
