package com.jerry.yzgl.login.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(String username,String password){
        return null;
    }
}
