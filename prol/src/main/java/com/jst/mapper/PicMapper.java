package com.jst.mapper;

import com.jst.entity.Book;
import com.jst.entity.Image;
import com.jst.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PicMapper {
    @Insert("insert into t_image values (null,#{image},#{tel}")
    public int insertImage(Image image);


    @Select("select * from t_image where tel=#{tel}")
    Image selectImageById(String tel);

    @Update("update t_image set  image = #{image} where tel = #{tel}")
    int updateImage(Image image);
}
