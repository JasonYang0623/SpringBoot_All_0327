package com.jason.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jason
 * @date 2023/3/28 11:00
 * @content 相关页码
 */
@Data
@AllArgsConstructor
public class BookDto {
    private long pageNum;
    private long totalPages;
    private long pageSize;
    private long totalElements;//总的条数
}
