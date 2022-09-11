package com.jerry.yzgl.yw.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.jerry.yzgl.util.ResultVO;
import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.domain.Dic;
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
 * 前端控制器
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@RestController
@RequestMapping("/dic")
public class DicController {

    private Logger logger = LoggerFactory.getLogger(DicController.class);

    @Autowired
    private IDicService dicService;

    @Autowired
    private IDicitemService dicitemService;

    @ApiOperation("新增字典项接口")
    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVO add(Dic dic) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("新增字典项失败");
        try {
            dic.setId(UUIDUtils.getUUID());
            dicService.save(dic);
            resultVO.setCode(200);
            resultVO.setMsg("新增字典项成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增字典项失败");
        }
        return resultVO;
    }
    @ApiOperation("修改字典项接口")
    @ResponseBody
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResultVO edit(Dic dic) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("修改字典项失败");
        try {
            dicService.updateById(dic);
            resultVO.setCode(200);
            resultVO.setMsg("修改字典项成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改字典项失败");
        }
        return resultVO;
    }
    @ApiOperation("删除字典项接口")
    @ResponseBody
    @RequestMapping(value = "del",method = RequestMethod.POST)
    public ResultVO del(String id) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("删除字典项失败");
        try {
            dicService.removeById(id);
            //连带删除字典数据
            Map<String,Object> map = new HashMap<>();
            map.put("dicitem_code",dicService.getById(id));
            dicitemService.removeByMap(map);
            resultVO.setCode(200);
            resultVO.setMsg("删除字典项成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除字典项失败");
        }
        return resultVO;
    }

    @ApiOperation("查询字典项接口")
    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResultVO list() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(400);
        resultVO.setMsg("查询字典项失败");
        try {
            resultVO.setData(dicService.list());
            resultVO.setCode(200);
            resultVO.setMsg("查询字典项成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询字典项失败");
        }
        return resultVO;
    }
}

