package com.qiyu.boot.dao;

import com.qiyu.boot.entity.User;

import java.util.List;

/**
 * @author qiyu
 * @date 2017-02-25 09:07
 * @since 1.8
 * @version 1.0.0
 */
public interface IUserDao {

    int insert(User user);

    List<User> queryList();
}
