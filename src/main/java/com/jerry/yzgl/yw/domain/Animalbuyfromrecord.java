package com.jerry.yzgl.yw.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("animalbuyfromrecord")
public class Animalbuyfromrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 动物id（外键）
     */
    private String animalId;

    /**
     * 卖家名称
     */
    private String buyfromUserName;

    /**
     * 卖家联系方式
     */
    private String buyfromUserPhone;

    /**
     * 卖家地址
     */
    private String buyfromUserLocation;

    /**
     * 买入时价格
     */
    private BigDecimal buyfromPrice;

    /**
     * 买入时间
     */
    private String buyfromTime;

    /**
     * 买入时体重(单位：kg)
     */
    private BigDecimal buyfromWeight;

    /**
     * 买入方式（自行派车，卖家运送）
     */
    private String buyfromType;

    /**
     * 车辆派遣记录id
     */
    private String buyfromCarId;


}
