package com.jerry.yzgl.yw.domain.vo;

import java.math.BigDecimal;

/**
 * <p>
 * 车辆派遣中视图对象
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
public class CarsrecordVo {

    private String id;

    /**
     * 车辆名称
     */
    private String carName;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverHome() {
        return driverHome;
    }

    public void setDriverHome(String driverHome) {
        this.driverHome = driverHome;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public String getCarUseTime() {
        return carUseTime;
    }

    public void setCarUseTime(String carUseTime) {
        this.carUseTime = carUseTime;
    }

    public String getCarUseType() {
        return carUseType;
    }

    public void setCarUseType(String carUseType) {
        this.carUseType = carUseType;
    }

    public String getCarBackTime() {
        return carBackTime;
    }

    public void setCarBackTime(String carBackTime) {
        this.carBackTime = carBackTime;
    }

    public BigDecimal getCarPay() {
        return carPay;
    }

    public void setCarPay(BigDecimal carPay) {
        this.carPay = carPay;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
