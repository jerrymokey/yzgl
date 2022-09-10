package com.jerry.yzgl.yw.controller;

import com.jerry.yzgl.current.CurrentUserUtil;
import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.TimeUtil;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Users;
import com.jerry.yzgl.yw.service.IUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author： jerry
 * @version： 2022/9/10 12:40
 * 登录控制器
 */
@ApiOperation("登录相关接口")
@RestController
@RequestMapping("login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private IUsersService usersService;

    @ApiOperation("注册接口")
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultVO register(HttpServletRequest request, String userName, String password, String phone, String orgName) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("注册失败");
        try {
            if (CheckParamUtils.check(userName) && CheckParamUtils.check(password) && CheckParamUtils.check(phone) && CheckParamUtils.check(orgName)) {
                Users users = new Users();
                users.setId(UUIDUtils.getUUID());
                users.setUserName(userName);
                users.setPassword(password);
                users.setPhone(phone);
                users.setOrgName(orgName);
                users.setRegisterTime(String.valueOf(System.currentTimeMillis()));
                usersService.save(users);
                resultVO.setMsg("注册成功");
                resultVO.setCode(200);
                logger.info(userName + "注册成功，注册时间：" + TimeUtil.stampToDate(users.getRegisterTime()));
            } else {
                resultVO.setMsg("注册信息不合法");
                resultVO.setCode(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("注册失败");
        }
        return resultVO;
    }

    @ApiOperation("登录接口")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultVO login(HttpServletRequest request, String phone, String password) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("登录失败");
        try {
            if (CheckParamUtils.check(phone) && CheckParamUtils.check(password)) {
                Map<String, Object> map = new HashMap<>();
                map.put("phone", phone);
                map.put("password", password);
                List<Users> users = usersService.listByMap(map);
                if (users.size() > 0) {
                    resultVO.setMsg("登录成功");
                    resultVO.setCode(200);
                    Users users1 = new Users();
                    users1.setId(users.get(0).getId());
                    users1.setLoginTime(String.valueOf(System.currentTimeMillis()));
                    usersService.updateById(users1);
                    logger.info(users.get(0).getUserName() + "登录成功，登陆时间：" + TimeUtil.stampToDate(users1.getLoginTime()));
                    CurrentUserUtil.setUserName(users.get(0).getUserName());
                    CurrentUserUtil.setOrgName(users.get(0).getOrgName());
                }
            } else {
                resultVO.setMsg("登录失败");
                resultVO.setCode(400);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("登录失败");
        }
        return resultVO;
    }
}
