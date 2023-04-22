package com.jason.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Jason
 * @date 2023/3/27 10:26
 * @content
 */
@Data
@TableName(value = "t_book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
