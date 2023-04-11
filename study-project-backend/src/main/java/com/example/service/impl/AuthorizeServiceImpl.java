package com.example.service.impl;

import com.example.entity.Account;
import com.example.mapper.UserMapper;
import com.example.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    @Resource
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        Account account = userMapper.findAccountByName(username);
        if(account == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles("user")
                .build();
    }

    @Override
    public boolean sendValidateEmail(String email) {
        /*
          1  生成验证码
          2  把邮箱和对应的验证码直接放到Redis（3分中国企）
          3  发送验证码到指定邮箱
          4  发生失败  删除redis中数据
          5  注册时 从redis取出数据 比较是否一致
         */

        return false;
    }
}
