package com.jerry.yzgl.current;
/**
 * @author： jerry
 * @version： 2022/9/10 15:05
 * 当前登录用户信息
 */

public class CurrentUserUtil {
    public CurrentUserUtil() {
    }
    private static String userName = null;
    private static String orgName = null;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        CurrentUserUtil.userName = userName;
    }

    public static String getOrgName() {
        return orgName;
    }

    public static void setOrgName(String orgName) {
        CurrentUserUtil.orgName = orgName;
    }

    public static String getCurrentUserInfo() {
        return "当前登录人信息：{" +
                "用户名称='" + userName + '\'' +
                ", 公司名称='" + orgName + '\'' +
                '}';
    }
}
