package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Animalbuyfromrecord;
import com.jerry.yzgl.yw.domain.Animals;
import com.jerry.yzgl.yw.service.IAnimalbuyfromrecordService;
import com.jerry.yzgl.yw.service.IAnimalsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/animalbuyfromrecord")
public class AnimalbuyfromrecordController {
    private Logger logger = LoggerFactory.getLogger(AnimalbuyfromrecordController.class);
    @Autowired
    private IAnimalbuyfromrecordService animalbuyfromrecordService;

    @ApiOperation("新增牲畜买入记录接口")
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultVO add(Animalbuyfromrecord animalbuyfromrecord) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增牲畜买入记录失败");
        try {
            animalbuyfromrecord.setId(UUIDUtils.getUUID());
            if (CheckParamUtils.check(animalbuyfromrecord.getAnimalId())) {
                animalbuyfromrecordService.save(animalbuyfromrecord);
                resultVO.setCode(200);
                resultVO.setMsg("新增牲畜买入记录成功");
            }
            resultVO.setMsg("请先新增牲畜信息");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增牲畜买入记录失败");
        }
        return resultVO;
    }
}

