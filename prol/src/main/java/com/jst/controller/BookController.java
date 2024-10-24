package com.jst.controller;

import com.jst.biz.BookBiz;
import com.jst.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookBiz biz;

    @RequestMapping("/book/list")
    public Map findBooks(){
        List<Book> list = biz.findAll();

        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("books",list);
        return result;
    }

    @RequestMapping("/book/add")
    public Map add(Book book){
        this.biz.addBook(book);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加");
        return result;
    }
    @RequestMapping("/book/del")
    public Map del(int id){

        Map result = new HashMap<>();
        if(this.biz.delBook(id)){
            result.put("isOk",true);
            result.put("msg","删除成功");
        }else{
            result.put("isOk",false);
            result.put("msg","删除失败");
        }

        return result;
    }

    @RequestMapping("/book/Change")
    public Map change(Book book)
    {


        Map result = new HashMap<>();
        if(this.biz.ChangBook(book)){
            result.put("isOk",true);
            result.put("msg","修改成功");
        }else{
            result.put("isOk",false);
            result.put("msg","修改失败");
        }

        return result;
    }

    @RequestMapping("/book/Select")
    public Map select(String title)
    {
        System.out.println(title);
        Book book=biz.selectBook(title);
        Map result = new HashMap<>();
        if(book!=null){
        result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("book",book);
        return result;}
        else{
            result.put("isOk",false);
            result.put("msg","查询失败");
            return result;
        }
    }

    public void setBiz(BookBiz biz) {
        this.biz = biz;
    }
}
