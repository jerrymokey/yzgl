package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Cars;
import com.jerry.yzgl.yw.domain.Carsrecord;
import com.jerry.yzgl.yw.domain.vo.CarsrecordVo;
import com.jerry.yzgl.yw.service.ICarsService;
import com.jerry.yzgl.yw.service.ICarsrecordService;
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
 * 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/carsrecord")
public class CarsrecordController {
    private Logger logger = LoggerFactory.getLogger(CarsrecordController.class);

    @Autowired
    private ICarsrecordService carsrecordService;

    @Autowired
    private ICarsService carsService;

    @ApiOperation("车辆派遣接口")
    @ResponseBody
    @RequestMapping(value = "useCar", method = RequestMethod.POST)
    public ResultVO useCar(Carsrecord carsrecord) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("车辆派遣失败");
        try {
            Cars car = carsService.getById(carsrecord.getCarId());
            if (car == null) {
                resultVO.setMsg("未查询到车辆信息");
            } else {
                carsrecord.setId(UUIDUtils.getUUID());
                carsrecordService.save(carsrecord);
                resultVO.setMsg("车辆派遣成功");
                //更新用车信息
                car.setIsUse(1);
                carsService.updateById(car);
                logger.info("更新用车信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("车辆派遣失败");
        }
        return resultVO;
    }

    @ApiOperation("收车接口")
    @ResponseBody
    @RequestMapping(value = "backCar", method = RequestMethod.POST)
    public ResultVO backCar(Carsrecord carsrecord) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("收车失败");
        try {
            carsrecordService.updateById(carsrecord);
            Cars car = carsService.getById(carsrecord.getCarId());
            car.setIsUse(0);
            carsService.updateById(car);
            logger.info("更新用车信息");
            resultVO.setCode(200);
            resultVO.setMsg("收车成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("收车失败");
        }
        return resultVO;
    }

    @ApiOperation("查询车辆派遣记录")
    @ResponseBody
    @RequestMapping(value = "queryList", method = RequestMethod.GET)
    public ResultVO queryList(String carId, String buyfromCarId) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询车辆派遣记录失败");
        try {
            Map<String, Object> map = new HashMap<>();
            if (CheckParamUtils.check(buyfromCarId))
                map.put("id", buyfromCarId);
            if (CheckParamUtils.check(carId))
                map.put("car_id", carId);
            List<Carsrecord> carsrecordList = carsrecordService.listByMap(map);
            if (carsrecordList.size()>0){
                List<CarsrecordVo> carsrecordVos = carsrecordService.parseCarsrecordVoList(carsrecordList);
                resultVO.setData(carsrecordVos);
            }
            resultVO.setCode(200);
            resultVO.setMsg("查询车辆派遣记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询车辆派遣记录失败");
        }
        return resultVO;
    }
}

