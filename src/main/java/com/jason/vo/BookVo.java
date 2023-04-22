package com.jason.vo;

import lombok.Data;

/**
 * @author Jason
 * @date 2023/3/28 10:32
 * @content
 */
@Data
public class BookVo {
    //当前页面
    private Integer pageNum=0;
    //页面显示条数
    private Integer pageSize=5;
    //总的条数
    private Integer totalPages;
    private String name;//前端传递的name，通过name查询

}
