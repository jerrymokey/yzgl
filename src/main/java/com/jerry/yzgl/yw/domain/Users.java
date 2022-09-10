package com.jerry.yzgl.yw.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author jerry
 * @since 2022-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private String id;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户注册时间
     */
    private String registerTime;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 公司名称
     */
    private String orgName;

    /**
     * 用户上次登录时间
     */
    private String loginTime;

}
