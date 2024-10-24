package com.jst.mapper;

import com.jst.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookMapper {
    @Select("select * from t_book")
    List<Book> selectBooks();
    @Select("select * from t_book where bookid=#{bookId}")
    Book selectBookById(int bookId);
    @Insert("insert into t_book values(null,#{title},#{price},#{desci})")
    void insertBook(Book book);
    @Delete("delete from t_book where bookid=#{id}")
    int deleteBookById(int id);

    @Update("update t_book set title = #{title}, price = #{price}, desci = #{desci} where bookid = #{bookId}")
    int updateBook(Book book);

    @Select("select * from t_book where title = #{title}")
    Book selectBookByTitle(String title);
}
