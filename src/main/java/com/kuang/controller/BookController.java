package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: yuhongtao
 * @date: 2022/1/30 - 19:33
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("booksList", booksList);
        System.out.println("(全部书籍)==>");
        for (Books book : booksList) {
            System.out.println(book);
        }
        return "allBook";
    }

    // 跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    // 添加书籍方法
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println("addBook==>" + books);
        bookService.addBook(books);
        // 重定向到@RequestMapping("/allBook")的请求
        return "redirect:/book/allBook";
    }

//    跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model) {
        System.out.println("id = " + id);
        Books books = bookService.queryBookById(id);
        System.out.println("查询的书籍=>" + books);
        model.addAttribute("query_book",books);
        return "updateBook";
    }

//    在修改页面点击确认修改，传到这里，进行修改
    @RequestMapping("/updateBook")
    public String updateBook(Books book, Model model) {
        System.out.println("(修改书籍功能)传过来的book信息=>" + book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

//    删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public  String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
