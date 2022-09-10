package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.current.CurrentUserUtil;
import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.yw.domain.Users;
import com.jerry.yzgl.yw.service.IUsersService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-10
 */
@ApiOperation("用户相关接口")
@RestController
@RequestMapping("/users")
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private IUsersService usersService;

    @ApiOperation("获取当前登陆人信息接口")
    @ResponseBody
    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    public ResultVO getCurrentUser(HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        if (CurrentUserUtil.getCurrentUserInfo().size() <= 0) {
            resultVO.setMsg("未检测到登录信息");
        } else {
            resultVO.setMsg("获取当前登录人信息成功");
            resultVO.setCode(200);
            resultVO.setData(CurrentUserUtil.getCurrentUserInfo());
            logger.info("获取当前登录人信息成功===" + resultVO.getData());
        }
        return resultVO;
    }

    @ApiOperation("查询用户信息接口")
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultVO list(HttpServletRequest request) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("暂无用户信息");
        try {
            List<Users> usersList = usersService.list() ;
            if (usersList!=null && usersList.size()>0){
                resultVO.setData(usersList);
                resultVO.setMsg("查询用户信息成功");
                resultVO.setCode(200);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("查询用户信息失败");
        }
        return resultVO;
    }

    @ApiOperation("删除用户信息接口(支持单删和批量删)")
    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ResultVO del(HttpServletRequest request,String ids) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("删除失败");
        try {
            if (CheckParamUtils.check(ids)){
                String[] id = ids.split(",");
                List<String> list = new ArrayList<>();
                for (int i = 0; i < id.length; i++) {
                    list.add(id[i]);
                }
                usersService.removeByIds(list) ;
                resultVO.setCode(200);
                resultVO.setMsg("删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除用户信息失败");
        }
        return resultVO;
    }
}

