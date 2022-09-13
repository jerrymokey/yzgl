package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.CheckParamUtils;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Animalbuyfromrecord;
import com.jerry.yzgl.yw.domain.Animals;
import com.jerry.yzgl.yw.domain.dto.AnimalBufromRecordDto;
import com.jerry.yzgl.yw.service.IAnimalbuyfromrecordService;
import com.jerry.yzgl.yw.service.IAnimalsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private IAnimalsService animalsService;

    /**
     * @author： jerry
     * @version： 2022/9/12 13:21
     * 新增牲畜买入记录  (此处不涉及到车辆派遣，一般由卖家自行运送)
     */
    @ApiOperation("新增牲畜买入记录接口")
    @ResponseBody
    @RequestMapping(value = "/addByUser", method = RequestMethod.POST)
    public ResultVO addByUser(AnimalBufromRecordDto animalBufromRecordDto, @RequestBody List<Animals> animalsList) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增牲畜买入记录失败");
        try {
            if (animalsList == null || animalsList.size() <= 0) {
                resultVO.setMsg("请先完善牲畜信息");
            } else {
                //要插入数据库的牲畜信息
                List<Animals> animalList = new ArrayList<>();
                //要插入数据库的牲畜买入信息
                List<Animalbuyfromrecord> animalbuyfromrecordList = new ArrayList<>();
                for (Animals animals : animalsList) {
                    Animals animal = new Animals();
                    BeanUtils.copyProperties(animals, animal);
                    animal.setId(UUIDUtils.getUUID());
                    animal.setIsDelete(0);
                    animalList.add(animal);

                    Animalbuyfromrecord animalbuyfromrecord = new Animalbuyfromrecord();
                    BeanUtils.copyProperties(animalBufromRecordDto, animalbuyfromrecord);
                    animalbuyfromrecord.setId(UUIDUtils.getUUID());
                    animalbuyfromrecord.setAnimalId(animal.getId());
                    animalbuyfromrecord.setBuyfromPrice(animal.getAnimalBuyfromPrice());
                    animalbuyfromrecord.setBuyfromWeight(animal.getAnimalWeight());

                    animalbuyfromrecord.setBuyfromType("卖家运送");
                    animalbuyfromrecordList.add(animalbuyfromrecord);
                }
                //插入牲畜信息
                if (animalsService.saveBatch(animalList)) {//保证事务提交后再录入买入牲畜记录
                    //插入牲畜买入信息
                    animalbuyfromrecordService.saveBatch(animalbuyfromrecordList);
                }
                resultVO.setMsg("新增牲畜成功，新增牲畜买入信息成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增牲畜买入记录失败");
        }
        return resultVO;
    }

    @ApiOperation("根据牲畜id查询牲畜买入记录接口")
    @ResponseBody
    @RequestMapping(value = "/selectByAnimal", method = RequestMethod.GET)
    public ResultVO selectByAnimal(String animalId) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询牲畜买入记录失败");
        try {
            if (CheckParamUtils.check(animalId)) {
                Map<String,Object> map = new HashMap<>();
                map.put("animal_id",animalId);
                resultVO.setData(animalbuyfromrecordService.listByMap(map));
                resultVO.setCode(200);
                resultVO.setMsg("查询牲畜买入记录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询牲畜买入记录失败");
        }
        return resultVO;
    }

    @ApiOperation("根据车辆派遣记录查询牲畜买入记录接口")
    @ResponseBody
    @RequestMapping(value = "/selectByCarRecord", method = RequestMethod.GET)
    public ResultVO selectByCarRecord(String carRecordId) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询牲畜买入记录失败");
        try {
            if (CheckParamUtils.check(carRecordId)) {
                Map<String,Object> map = new HashMap<>();
                map.put("buyfrom_car_id",carRecordId);
                resultVO.setData(animalbuyfromrecordService.listByMap(map));
                resultVO.setCode(200);
                resultVO.setMsg("查询牲畜买入记录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询牲畜买入记录失败");
        }
        return resultVO;
    }

    @ApiOperation("分类查询牲畜买入记录接口")
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public ResultVO queryList(String queryType,Integer pageNo,Integer pageSize) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询牲畜买入记录失败");
        try {
            List<Animalbuyfromrecord> animalbuyfromrecords = new ArrayList<>();
            if (CheckParamUtils.check(queryType)) {
                animalbuyfromrecords = animalbuyfromrecordService.list();
                //lambda表达式实现物理分页
                List<Animalbuyfromrecord> animalbuyfromrecordList = animalbuyfromrecords.stream()
                        .sorted(Comparator.comparing(Animalbuyfromrecord::getBuyfromTime).reversed())
                        .skip((long) (pageNo - 1) * pageSize)
                        .limit(pageSize)
                        .collect(Collectors.toList());
                animalbuyfromrecords = animalbuyfromrecordList;
            }else {
                Map<String,Object> map = new HashMap<>();
                map.put("buyfrom_type",queryType);
                animalbuyfromrecords = animalbuyfromrecordService.listByMap(map);
            }
            resultVO.setData(animalbuyfromrecords);
            resultVO.setCode(200);
            resultVO.setMsg("查询牲畜买入记录成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询牲畜买入记录失败");
        }
        return resultVO;
    }
}

