package com.yuxiu.edu.eb.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuxiu.edu.eb.service.IUserService;
import com.yuxiu.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("find")
    @ResponseBody
    public void find(Integer id){
        User user = userService.findById(id);
        System.out.println("dubbo服务返回的数据:" +user);
        responseJson(user);

    }

    public void responseJson(Object obj){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader("Content-Type","text/json;charset=utf-8");
        //ServletContext context = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        ObjectMapper mapper = new ObjectMapper();
        try {
            response.getWriter().write(mapper.writeValueAsString(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
