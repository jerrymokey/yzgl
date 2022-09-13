package com.jerry.yzgl.yw.domain.dto;
/**
 * @author： jerry
 * @version： 2022/9/12 13:54
 * 前端录入牲畜信息dto
 */

public class AnimalBufromRecordDto {

    private String buyfromUserName;
    private String buyfromUserPhone ;
    private String buyfromUserLocation ;
    private String buyfromTime;

    public String getBuyfromUserName() {
        return buyfromUserName;
    }

    public void setBuyfromUserName(String buyfromUserName) {
        this.buyfromUserName = buyfromUserName;
    }

    public String getBuyfromUserPhone() {
        return buyfromUserPhone;
    }

    public void setBuyfromUserPhone(String buyfromUserPhone) {
        this.buyfromUserPhone = buyfromUserPhone;
    }

    public String getBuyfromUserLocation() {
        return buyfromUserLocation;
    }

    public void setBuyfromUserLocation(String buyfromUserLocation) {
        this.buyfromUserLocation = buyfromUserLocation;
    }

    public String getBuyfromTime() {
        return buyfromTime;
    }

    public void setBuyfromTime(String buyfromTime) {
        this.buyfromTime = buyfromTime;
    }
}
