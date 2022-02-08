package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yuhongtao
 * @date: 2022/1/30 - 18:54
 */
public interface BookMapper {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(@Param("id") int id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book,这里写@Param的话，注意变量名一致，否则报错
    Books queryBookById(@Param("id") int id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();

}
