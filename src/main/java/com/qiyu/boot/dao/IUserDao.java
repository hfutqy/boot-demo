package com.qiyu.boot.dao;

import com.qiyu.boot.entity.User;

import java.util.List;

/**
 * @author qiyu
 * @version 1.0.0
 * @date 2017-02-25 09:07
 * @since 1.8
 */
public interface IUserDao {

    int insert(User user);

    List<User> queryList();
}
