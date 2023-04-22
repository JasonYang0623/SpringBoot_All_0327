package com.jason.controller;

import com.jason.domain.User;
import com.jason.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * @author Jason
 * @date 2023/3/27 10:41
 * @javadoc
 */
@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    //定义一个RequestMapping映射请求路径为“/login”的Post请求
    @PostMapping("/login")
    public String loginByNameAndPassword(User user, HttpSession session) {
//        //在控制台打印用户信息
//        System.out.println(user);
//        //调用userService的queryUserByNameAndPassWord方法，获取用户
//        User user1=iUserService.queryUserByNameAndPassWord(user);
//        //在控制台打印获取的用户信息
//        System.out.println(user1);
//        //如果获取的用户为空或者等于空字符串
//        if (user1==null||user1.equals("")) {
//            //记录登录失败日志
//            log.info("登录失败");
//            //返回登录页面
//            return "login";
//        }
//        else {
//            //将用户信息存储到session中
//            session.setAttribute("user",user1);
//            //重定向到书籍列表页
//            log.info("登录成功，转到书籍列表页");
//            return "redirect:/books/list";
//        }
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        currentUser.login(token);
        if (currentUser.isAuthenticated()) {
            session.setAttribute("user", user);
            return "redirect:/books/list";
        }
        return "login";
    }


    @PostMapping("/register")
    public String insertUser(String username, String password, String password1) {
        if (password.equals(password1)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            boolean flag = iUserService.insertUser(user);
            if (flag) {
               log.info("注册成功");
            } else {
               log.info("注册失败");
            }
        } else {
            log.info("两次密码输入不一致出现错误");
        }
        return "login";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "login";
    }

}
