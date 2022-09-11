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
@TableName("carsrecord")
public class Carsrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    /**
     * 车辆id（外键）
     */
    private String carId;

    /**
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机联系方式
     */
    private String driverPhone;

    /**
     * 司机家庭住址（简单描述）
     */
    private String driverHome;

    /**
     * 车辆派遣地点（用户手动录入）
     */
    private String carLocation;

    /**
     * 车辆派遣时间
     */
    private String carUseTime;

    /**
     * 车辆派遣类型（购买牲畜，运送牲畜，农活，清理粪便）四种情况走四种接口
     */
    private String carUseType;

    /**
     * 车辆返回时间
     */
    private String carBackTime;

    /**
     * 车辆支出费用（包括路费，餐饮费，油费等等）
     */
    private BigDecimal carPay;

    /**
     * 车辆运载情况（空载，小有收获，满载而归）
     */
    private String carStatus;

    /**
     * 备注
     */
    private String remark;


}
