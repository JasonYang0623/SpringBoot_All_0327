package com.jason.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jason.domain.Book;
import com.jason.dto.BookDto;
import com.jason.service.IBookService;
import com.jason.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Jason
 * @date 2023/3/27 17:06
 * @content
 */
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    /**
     * @param bookVo
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String getBookPages(BookVo bookVo, Model model, HttpSession session) {

        if (session.getAttribute("user") == null || session.getAttribute("user") == "") {
            return "login";
        }
        IPage<Book> pages = iBookService.queryBooks(bookVo);
        List<Book> records = pages.getRecords();
        BookDto pageInfo = new BookDto(pages.getCurrent(), pages.getPages(), pages.getSize(), pages.getTotal());
        model.addAttribute("books", records);
        model.addAttribute("pageInfo", pageInfo);
        return "book_list";
    }


    @PostMapping("/add")
    public String addBooks(Book book) {
        Boolean flag = iBookService.addBooks(book);
        return flag ? "add" : "add";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooks(@PathVariable Integer id) {
        Book book = new Book();
        book.setId(id);
        System.out.println(book);
        boolean flag = iBookService.deleteBooks(book);
        return flag ? "redirect:/books/list" : "redirect:/books/list";
    }

    @GetMapping("/edit/{id}")
    public String editBooks(@PathVariable Integer id, Model model) {
        //查数据
        Book book = iBookService.getBookById(id);
        //绑定视图
        model.addAttribute("book", book);
        System.out.println(book);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateBook(Book book) {
        boolean flag = iBookService.updateBook(book);
        return flag ? "redirect:/books/list" : "redirect:/books/edit/" + book.getId();
    }

}
