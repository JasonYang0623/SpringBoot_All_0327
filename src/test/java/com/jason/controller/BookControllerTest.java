package com.jason.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jason.domain.Book;
import com.jason.service.IBookService;
import com.jason.vo.BookVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jason
 * @date 2023/3/28 11:32
 * @content
 */
@SpringBootTest
class BookControllerTest {
    @Autowired
    private IBookService iBookService;
    @Test
    void getBookPages() {
        BookVo bookVo = new BookVo();
        //bookVo.setName("活着");
        IPage<Book> bookIPage = iBookService.queryBooks(bookVo);
        System.out.println(bookIPage.getRecords());
    }
}