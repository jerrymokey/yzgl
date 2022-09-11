package com.jerry.yzgl.yw.controller;


import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Dic;
import com.jerry.yzgl.yw.domain.Dicitem;
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
@RequestMapping("/dicitem")
public class DicitemController {
    private Logger logger = LoggerFactory.getLogger(DicitemController.class);

    @Autowired
    private IDicitemService dicitemService;

    @ApiOperation("新增字典数据接口")
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVO add(String dicCode,String dicItemName) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增字典项失败");
        try {
            Dicitem dicitem = new Dicitem();
            dicitem.setId(UUIDUtils.getUUID());
            dicitem.setDicitemName(dicItemName);
            dicitem.setDicitemCode(dicCode);
            dicitemService.save(dicitem);
            resultVO.setCode(200);
            resultVO.setMsg("新增字典数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增字典数据失败");
        }
        return resultVO;
    }

    @ApiOperation("删除字典数据接口")
    @ResponseBody
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public ResultVO del(String id) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("删除字典数据失败");
        try {
            dicitemService.removeById(id);
            resultVO.setCode(200);
            resultVO.setMsg("删除字典数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除字典数据失败");
        }
        return resultVO;
    }

    @ApiOperation("获取字典数据接口")
    @ResponseBody
    @RequestMapping(value = "getData",method = RequestMethod.GET)
    public ResultVO getData(String dicItemCode){//字典标识
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("获取字典数据失败");
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("dicitem_code",dicItemCode);
            resultVO.setCode(200);
            resultVO.setMsg("获取字典数据成功");
            resultVO.setData(dicitemService.listByMap(map));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取字典数据失败");
        }
        return resultVO;
    }
}

