package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Animals;
import com.jerry.yzgl.yw.service.IAnimalsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
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

    @ApiOperation("新增牲畜信息接口")
    @ResponseBody
    @RequestMapping(value = "/addAnimal", method = RequestMethod.POST)
    public ResultVO addAnimal(Animals animals) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增失败");
        try {
            animals.setId(UUIDUtils.getUUID());
            animalsService.save(animals);
            resultVO.setCode(200);
            resultVO.setMsg("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增牲畜信息失败");
        }
        return resultVO;
    }

    @ApiOperation("编辑牲畜信息接口")
    @ResponseBody
    @RequestMapping(value = "/editAnimal", method = RequestMethod.POST)
    public ResultVO editAnimal(Animals animals) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("修改失败");
        try {
            animalsService.updateById(animals);
            resultVO.setCode(200);
            resultVO.setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("跟新牲畜信息失败");
        }
        return resultVO;
    }

    @ApiOperation("删除牲畜信息接口（支持单条和批量）")
    @ResponseBody
    @RequestMapping(value = "/delAnimal", method = RequestMethod.POST)
    public ResultVO delAnimal(String animalIds) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("删除失败");
        try {
            if (CheckParamUtils.check(animalIds)) {
                String[] id = animalIds.split(",");
                List<String> list = new ArrayList<>();
                for (int i = 0; i < id.length; i++) {
                    list.add(id[i]);
                }
                animalsService.removeByIds(list);
                resultVO.setCode(200);
                resultVO.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除牲畜信息失败");
        }
        return resultVO;
    }

    @ApiOperation("查询牲畜信息接口")
    @ResponseBody
    @RequestMapping(value = "/animalList", method = RequestMethod.GET)
    public ResultVO animalList(HttpServletRequest request, String animalType, String animalHealth,
                               String animalSex, String animalLocation, Integer pageSize, Integer pageNo) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("暂无牲畜信息");
        try {
            Map<String, Object> map = new HashMap<>();
            if (CheckParamUtils.check(animalType))
                map.put("animal_type", animalType);
            if (CheckParamUtils.check(animalHealth))
                map.put("animal_health", animalHealth);
            if (CheckParamUtils.check(animalSex))
                map.put("animal_sex", animalSex);
            if (CheckParamUtils.check(animalLocation))
                map.put("animal_location", animalLocation);
            List<Animals> animalsList = animalsService.listByMap(map);
            if (animalsList != null && animalsList.size() > 0) {
                //lambda表达式实现物理分页
                List<Animals> animals = animalsList.stream()
                        .sorted(Comparator.comparing(Animals::getAnimalCode))
                        .skip((long) (pageNo - 1) * pageSize)
                        .limit(pageSize)
                        .collect(Collectors.toList());
                if (animals!=null&&animals.size()>0){
                    resultVO.setData(animals);
                    resultVO.setMsg("查询牲畜信息成功");
                    resultVO.setCode(200);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询牲畜信息失败");
        }
        return resultVO;
    }
}

