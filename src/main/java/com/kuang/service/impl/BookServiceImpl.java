package com.kuang.service.impl;

import com.kuang.dao.BookMapper;
import com.kuang.pojo.Books;
import com.kuang.service.BookService;

import java.util.List;

/**
 * @author: yuhongtao
 * @date: 2022/1/30 - 18:58
 */
public class BookServiceImpl implements BookService {
    //    service调用dao层
    private BookMapper bookMapper;

    //    这里可以用注解@Autowired省略set方法
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
