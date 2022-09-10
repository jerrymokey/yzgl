package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.current.CurrentUserUtil;
import com.jerry.yzgl.util.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-10
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(UsersController.class);

    @ApiOperation("获取当前登陆人信息接口")
    @ResponseBody
    @RequestMapping(value = "/getCurrentUser",method = RequestMethod.GET)
    public ResultVO getCurrentUser(HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        if (CurrentUserUtil.getCurrentUserInfo().size()<=0){
            resultVO.setCode(400);
            resultVO.setMsg("未检测到登录信息");
        }else {
            resultVO.setMsg("获取当前登录人信息成功");
            resultVO.setData(CurrentUserUtil.getCurrentUserInfo());
            logger.info("获取当前登录人信息成功===" + resultVO.getData());
        }
        return resultVO;
    }
}

