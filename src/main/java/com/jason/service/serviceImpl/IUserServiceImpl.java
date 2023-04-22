package com.jason.service.serviceImpl;

import com.jason.controller.UserController;
import com.jason.dao.IUserDao;
import com.jason.domain.User;
import com.jason.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jason
 * @date 2023/3/27 11:03
 * @content
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public Boolean insertUser(User user) {
        int row=userDao.insert(user);
        if(row>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User queryUserByNameAndPassWord(User user) {
        User user1=new User();
        user1= userDao.queryUserByNameAndPassWord(user);
        return user1;
    }

    @Override
    public User getCurretUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }
}
