package com.jason.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jason.dao.IBookDao;
import com.jason.domain.Book;
import com.jason.service.IBookService;
import com.jason.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @author Jason
 * @date 2023/3/27 18:49
 * @content
 */
@Service("bookService")
public class IBookServiceImpl implements IBookService {
    @Autowired
    private IBookDao iBookDao;

    /**
     * 通过页码实现分页查询
     * @param bookVo 前端查询字段映射BookVo
     * @return
     */
    @Override
    public IPage<Book> queryBooks(BookVo bookVo) {
        IPage<Book> page=new Page<>(bookVo.getPageNum(),bookVo.getPageSize());
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.orderByAsc("publish_date");
        if(null !=bookVo.getName()){
            //插入需要查询的参数
            qw.like("name",bookVo.getName());
        }
        return iBookDao.selectPage(page,qw);
    }

    @Override
    public Boolean addBooks(Book book) {
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        int row=iBookDao.insert(book);
        return row > 0;
    }

    @CacheEvict(value = "myCache",key = "#id")
    @Override
    public Boolean deleteBooks(Book book) {
        int row=iBookDao.deleteById(book);
        return row>0;
    }

    @Cacheable(value = "myCache",key = "#id")
    @Override
    public Book getBookById(Integer id) {
        return iBookDao.selectById(id);
    }

    @CachePut(value = "myCache",key = "#id")
    @Override
    public Boolean updateBook(Book book) {
        int rows=iBookDao.updateById(book);
        return rows>0;
    }
}
