package com.jerry.yzgl.yw.service;

import com.jerry.yzgl.yw.domain.Carsrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.yzgl.yw.domain.vo.CarsrecordVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
public interface ICarsrecordService extends IService<Carsrecord> {

    List<CarsrecordVo> parseCarsrecordVoList(List<Carsrecord> carsrecordList);
}
