package com.ll.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.domain.User;
import com.ll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户登陆
    @RequestMapping("/login")
    public String userLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = userService.findByUsernameAndPassword(username, password);
        if (loginUser != null) {
            request.getSession().setAttribute("user", loginUser);
            return "index";
        } else {
            request.setAttribute("login_msg", "用户名或密码错误!");
            return "login";
        }
    }

    //注册
    @RequestMapping("/regist")
    public String userRegist(@RequestParam("username")String username, @RequestParam("password")String password) {
        userService.insertUser(username, password);
        return "login";
    }

    //根据用户名查询用户
    @RequestMapping("/findUser")
    public void findUser(@RequestParam("username") String username, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        //查询用户要注册的用户名是否已经存在
        User user = userService.findByUsername(username);
        System.out.println(username);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎,请更换一个");
        }else {
            map.put("userExist", false);
            map.put("msg", "此用户名可用");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    @RequestMapping("/refresh")
    public void refreshUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        user = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/book/findBookByPage").forward(request, response);
    }
}
