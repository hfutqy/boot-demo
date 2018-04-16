package com.qiyu.boot.controller;

import com.github.pagehelper.PageHelper;
import com.qiyu.boot.entity.User;
import com.qiyu.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qiyu
 * @version 1.0.0
 * @date 2017-02-25 09:20
 * @since 1.8
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "add")
    public String insert(@Valid User user) {
        // user.setBirth(new Date());
//        log.info("请求参数:{}", user);
        return userService.insert(user);
    }

    /**
     * 获取用户列表
     *
     * @param start
     * @param size
     * @return
     */
    @GetMapping(value = "list/{start}/{size}")
    public List<User> getUserList(@PathVariable("start") int start, @PathVariable("size") int size) {
        PageHelper.startPage(start, size);
        List<User> list = userService.getList();
        return list;
    }
}
