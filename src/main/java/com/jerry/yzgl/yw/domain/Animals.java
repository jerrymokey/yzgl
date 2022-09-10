package com.jerry.yzgl.yw.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("animals")
public class Animals implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 动物名称（通俗易懂，口头白话取得名字，如果没有就不录入）
     */
    private String animalName;

    /**
     * 动物照片地址码（需要调用照片上传接口）
     */
    private String animalLogoCode;

    /**
     * 动物编号（人为自定义动物编号）
     */
    private String animalCode;

    /**
     * 动物位置（在家里圈养的位置  例如：一号棚左手侧中间位置）
     */
    private String animalLocation;

    /**
     * 动物类型（牛，马，骡子..）
     */
    private String animalType;

    /**
     * 动物性别（公，母）
     */
    private String animalSex;

    /**
     * 动物毛色
     */
    private String animalColor;

    /**
     * 动物年龄
     */
    private String animalAge;

    /**
     * 动物健康状况（健康，生病，残疾，死亡）
     */
    private String animalHealth;


}
