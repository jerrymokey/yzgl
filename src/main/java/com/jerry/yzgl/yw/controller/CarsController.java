package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.TimeUtil;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Cars;
import com.jerry.yzgl.yw.domain.Carsrecord;
import com.jerry.yzgl.yw.domain.Dic;
import com.jerry.yzgl.yw.service.ICarsService;
import com.jerry.yzgl.yw.service.ICarsrecordService;
import com.jerry.yzgl.yw.service.IDicService;
import com.jerry.yzgl.yw.service.IDicitemService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/cars")
public class CarsController {
    private Logger logger = LoggerFactory.getLogger(CarsController.class);

    @Autowired
    private ICarsService carsService;
    @Autowired
    private ICarsrecordService carsrecordService;

    @ApiOperation("新增车辆信息接口")
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVO add(Cars cars) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增车辆信息失败");
        try {
            cars.setId(UUIDUtils.getUUID());
            carsService.save(cars);
            resultVO.setCode(200);
            resultVO.setMsg("新增车辆信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增车辆信息失败");
        }
        return resultVO;
    }
    @ApiOperation("修改车辆信息接口")
    @ResponseBody
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResultVO edit(Cars cars) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("修改车辆信息失败");
        try {
            carsService.updateById(cars);
            resultVO.setCode(200);
            resultVO.setMsg("修改车辆信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改车辆信息失败");
        }
        return resultVO;
    }
    @ApiOperation("删除车辆信息接口")
    @ResponseBody
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public ResultVO del(String id) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("删除车辆信息失败");
        try {
            carsService.removeById(id);
            resultVO.setCode(200);
            resultVO.setMsg("删除车辆信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除车辆信息失败");
        }
        return resultVO;
    }

    @ApiOperation("查询车辆在用信息接口")
    @ResponseBody
    @RequestMapping(value = "useList",method = RequestMethod.GET)
    public ResultVO useList() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询车辆信息失败");
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("is_use",1);
            resultVO.setData(carsService.listByMap(map));
            resultVO.setCode(200);
            resultVO.setMsg("查询车辆信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询车辆信息失败");
        }
        return resultVO;
    }

    @ApiOperation("查询车辆闲置信息接口")
    @ResponseBody
    @RequestMapping(value = "noUseList",method = RequestMethod.GET)
    public ResultVO noUseList() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询车辆信息失败");
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("is_use",0);
            resultVO.setData(carsService.listByMap(map));
            resultVO.setCode(200);
            resultVO.setMsg("查询车辆信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询车辆信息失败");
        }
        return resultVO;
    }


}

