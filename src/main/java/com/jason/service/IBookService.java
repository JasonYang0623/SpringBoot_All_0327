package com.jason.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jason.domain.Book;
import com.jason.vo.BookVo;

/**
 * @author Jason
 * @date 2023/3/27 18:48
 * @content
 */
public interface IBookService {
    /**
     * 分页查询，映射bookVo实体
     *
     * @param bookVo
     * @return 返回list表
     */
    IPage<Book> queryBooks(BookVo bookVo);
    Boolean addBooks(Book book);

    Boolean deleteBooks(Book book);

    Book getBookById(Integer id);
    Boolean updateBook(Book book);


}
