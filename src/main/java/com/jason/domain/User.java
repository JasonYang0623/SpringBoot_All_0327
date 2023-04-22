package com.jason.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Jason
 * @date 2023/3/27 10:30
 * @content
 */
@Data
@TableName(value = "t_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String real_name;
    private String password;
}
