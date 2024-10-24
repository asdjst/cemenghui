package com.jst.controller;

import com.jst.biz.AdminBiz;

import com.jst.entity.Admin;
import com.jst.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminBiz biz;

    @RequestMapping("/login")
    public Map login(Admin admin, HttpSession session) {

        int flag = biz.checkLogin(admin);
        Map map = new HashMap();
        if (flag == 1) {
            session.setAttribute("login_admin", admin);

            map.put("isOk", true);
            map.put("admin", admin);
            map.put("msg", "登录成功");
            return map;
        }
        else{
            map.put("isOk", false);
            map.put("msg", "登录失败");
            return  map;
        }
    }
}
