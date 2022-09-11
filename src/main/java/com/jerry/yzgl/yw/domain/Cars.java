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
@TableName("cars")
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 车辆名称
     */
    private String carName;

    /**
     * 车辆类型（配置到字典表中（小型车，中型车，大型车））
     */
    private String carType;

    /**
     * 车主姓名
     */
    private String carUser;

    /**
     * 车牌号
     */
    private String carCode;

    private String carBuyTime;

    /**
     * 车辆吨位（单位吨）
     */
    private BigDecimal carWeight;

    /**
     * 车辆油料型号 （92号，95号，98号汽油，10#柴油、5＃柴油、0＃柴油、-10＃柴油、 -20＃柴油、-35＃柴油和-50＃柴油
     */
    private String carOil;

    /**
     * 车辆价格
     */
    private BigDecimal carPrice;

    /**
     * 车辆颜色
     */
    private String carColor;

    /**
     * 备注
     */
    private String remark;
    /**
     * 在用情况（0，闲置；1，在用）
     */
    private Integer isUse;


}
