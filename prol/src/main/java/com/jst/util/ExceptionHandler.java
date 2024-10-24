package com.jst.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public Map JsonError(Exception e){
        Map map = new HashMap();
        map.put("isOk",false);
//
        if(e instanceof MyException){
            map.put("msg",e.getMessage());
        }else {
            map.put("msg","严重的系统错误，请稍后运行或联系系统管理员");
        }


        return map;
    }
}
