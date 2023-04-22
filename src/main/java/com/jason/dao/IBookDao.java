package com.jason.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jason.domain.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jason
 * @date 2023/3/27 17:14
 * @content
 */
@Mapper
public interface IBookDao extends BaseMapper<Book> {
    List<Book> queryAllBooks();
}
