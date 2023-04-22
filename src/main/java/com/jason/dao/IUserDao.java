package com.jason.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jason
 * @date 2023/3/27 10:35
 * @content
 */
@Mapper
public interface IUserDao extends BaseMapper<User> {
    User queryUserByNameAndPassWord(User user);

    User queryUserByUsername(String username);
}
