package com.jerry.yzgl.current;

import com.alibaba.fastjson.JSONObject;
import com.jerry.yzgl.util.CheckParamUtils;

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

    public static JSONObject getCurrentUserInfo() {
      JSONObject jsonObject = new JSONObject();
      if (CheckParamUtils.check(getUserName()) && CheckParamUtils.check(getOrgName())){
          jsonObject.put("userName",getUserName());
          jsonObject.put("orgName",getOrgName());
      }
      return jsonObject;
    }
}
