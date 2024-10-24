package com.jst.controller;

import com.jst.biz.BookBiz;
import com.jst.biz.UserBiz;
import com.jst.entity.Book;
import com.jst.entity.Image;
import com.jst.entity.User;
import com.jst.mapper.PicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Controller//声明这个类是spring项目中的控制器类（相当于Servlet）
//@ResponseBody
@RestController//Controller+ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz biz;
    @Autowired
    private PicMapper Pmap;
    @RequestMapping("/register")
//    @ResponseBody//当前方法返回Json结构的数据
    public Map register(User user){
        System.out.println(user.getTel() + " " + user.getUserName() + " " + user.getLoginPwd());
        this.biz.addUser(user);

        Map map = new HashMap();
        map.put("isOk",true);
        map.put("msg","注册成功");
        return map;
    }
    @RequestMapping("/login")
//  @ResponseBody//当前方法返回Json结构的数据
    public Map login(User user, HttpSession session){
        System.out.println(user.getTel());
        user = biz.checkLogin(user);
        System.out.println(user.getTel());
        session.setAttribute("login_user",user);


        Map map = new HashMap();
        map.put("isOk",true);
        map.put("user",user);
        map.put("msg","登录成功");
        return map;
    }

    @RequestMapping("/logout")
    public Map logout(HttpSession session) {
        session.invalidate(); // 清除 session
        System.out.println("ok");
        Map map = new HashMap();
        map.put("isOk",true);
        map.put("msg","成功登出");
        return map;
    }

    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }



    @RequestMapping("list")
    public Map findUser(){
        List<User> list = biz.findAll();
         System.out.println("ok");
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("users",list);
        return result;
    }

    @RequestMapping("add")
    public Map add(User user){
        this.biz.addUser(user);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加");
        return result;
    }

    @RequestMapping("/del")
    public Map del(int userId){

        Map result = new HashMap<>();
        if(this.biz.delUser(userId)){
            result.put("isOk",true);
            result.put("msg","删除成功");
        }else{
            result.put("isOk",false);
            result.put("msg","删除失败");
        }

        return result;
    }

    @RequestMapping("/Change")
    public Map change(User user)
    {
        Map result = new HashMap<>();
        if(this.biz.ChangUser(user)){
            result.put("isOk",true);
            result.put("msg","修改成功");
        }else{
            result.put("isOk",false);
            result.put("msg","修改失败");
        }

        return result;
    }

    @RequestMapping("/Select")
    public Map select(String tel)
    {
        System.out.println(tel);
        User user=biz.selectUser(tel);
        Map result = new HashMap<>();
        if(user!=null) {

            result.put("isOk", true);
            result.put("msg", "查询成功");
            result.put("user", user);
            return result;
        }
        else{
            result.put("isOk", false);
            result.put("msg", "查询失败");
            return result;
        }
    }

    @RequestMapping("/SelPic")
    public Map selectPic(String tel)
    {
       Image image=Pmap.selectImageById(tel);
        Map result = new HashMap<>();if(image!=null)
       if(image!=null)
       { result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("url",image.getImage());
        return result;
       }
       else{
           result.put("isOk",false);
           result.put("msg","查询失败");
          return result;
       }
       return null;
    }

    @RequestMapping("/InsPic")
    public Map InsPic(Image image) {


        Map result = new HashMap<>();


        int a = Pmap.insertImage(image);
        System.out.println(image.getImage() + ' ' + image.getTel());
        if (a == 1) {

            result.put("isOk", true);
            result.put("msg", "添加成功");
            result.put("image", image);
            return result;
        } else {
            result.put("isOk", false);
            result.put("msg", "添加失败");

            return result;
        }

    }
        @RequestMapping("/ChangPic")
        public Map ChangePic(Image image)
        {
            Map result = new HashMap<>();

            if(this.selectPic(image.getTel()).get("isOk")!="false")
            {
               int a= Pmap.updateImage(image);
               if(a==1)
               {
                   result.put("isOk",true);
                   result.put("msg","改变成功");
                   result.put("url",image.getImage());

                   return result;
               }
               else{
                   result.put("isOk",false);
                   result.put("msg","改变失败");
                   return result;
               }
            }
            else{
                System.out.println(image.getImage()+' '+image.getTel());
                return this.InsPic(image);
            }


        }



}
