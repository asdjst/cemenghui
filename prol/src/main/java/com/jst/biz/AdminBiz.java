package com.jst.biz;

import com.jst.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminBiz {

    private String name="admin";
    private String password="admin123";
    public int checkLogin(Admin admin) {
        if(admin.getName().equals(name)&&admin.getPwd().equals(password))
            return 1;
        else {
            return 0;
        }
    }
}
