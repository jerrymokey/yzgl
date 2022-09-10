package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Animals;
import com.jerry.yzgl.yw.service.IAnimalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-10
 */
@ApiOperation("牲畜信息相关接口")
@RestController
@RequestMapping("/animals")
public class AnimalsController {
    private Logger logger = LoggerFactory.getLogger(AnimalsController.class);
    @Autowired
    private IAnimalsService animalsService;

    @ApiOperation("新增牲畜列表接口")
    @ResponseBody
    @RequestMapping(value = "/addAnimal",method = RequestMethod.POST)
    public ResultVO addAnimal(Animals animals){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增失败");
        try {
            animals.setId(UUIDUtils.getUUID());
            animalsService.save(animals);
            resultVO.setCode(200);
            resultVO.setMsg("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("新增牲畜失败");
        }
        return resultVO;
    }
}

