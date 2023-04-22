package com.jason.service;

import com.jason.domain.User;

/**
 * @author Jason
 * @date 2023/3/27 10:54
 * @content
 */
public interface IUserService {
    //添加用户
    Boolean insertUser(User user);
    User queryUserByNameAndPassWord(User user);

    User getCurretUserByUsername(String username);
}
