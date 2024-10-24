package com.jst.biz;

import com.jst.entity.Book;
import com.jst.entity.User;
import com.jst.mapper.UserMapper;
import com.jst.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBiz {
    @Autowired
    private UserMapper mapper;
    public User checkLogin(User user){
        System.out.println(user.getTel());
        User dbUser = mapper.selectUserByTel(user.getTel());
        System.out.println(user.getTel());
        if(dbUser!=null && dbUser.getLoginPwd().equals(user.getLoginPwd())){
            dbUser.setLoginPwd(null);
            return dbUser;
        }else {
            throw new MyException("登录失败，账号不存在或密码错误");
        }
    }

    public void addUser(User user){

        this.mapper.insertUser(user);

    }


    public List<User> findAll(){
        return mapper.selectUsers();
    }



    public boolean delUser(int userId){
        return this.mapper.deleteUserById(userId)>0;
    }

    public boolean ChangUser(User user){

        return this.mapper.updateUser(user)>0;
    }

    public User selectUser(String tel){ return this.mapper .selectUserByTel(tel);}

    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}
