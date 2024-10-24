package com.jst.mapper;

import com.jst.entity.Book;
import com.jst.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where tel=#{tel}")
    public User selectUserByTel(String tel);
    @Insert("insert into t_user values (null,#{tel},#{loginPwd},#{userName})")
    public int insertUser(User user);


    @Select("select * from t_user")
    List<User> selectUsers();

    @Delete("delete from t_user where userId=#{userId}")
    int deleteUserById(int userId);

    @Update("update t_user set tel = #{tel}, loginPwd = #{loginPwd}, userName = #{userName} where userId = #{userId}")
    int updateUser(User user);


}
