package com.jerry.yzgl.yw.service.impl;

import com.jerry.yzgl.util.TimeUtil;
import com.jerry.yzgl.yw.domain.Carsrecord;
import com.jerry.yzgl.yw.dao.CarsrecordDao;
import com.jerry.yzgl.yw.domain.vo.CarsrecordVo;
import com.jerry.yzgl.yw.service.ICarsService;
import com.jerry.yzgl.yw.service.ICarsrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jerry
 * @since 2022-09-11
 */
@Service
public class CarsrecordServiceImpl extends ServiceImpl<CarsrecordDao, Carsrecord> implements ICarsrecordService {

    @Autowired
    private ICarsService iCarsService;
    @Override
    public List<CarsrecordVo> parseCarsrecordVoList(List<Carsrecord> carsrecordList) {
        List<CarsrecordVo> carsrecordVoList = new ArrayList<>();
        for (Carsrecord carsrecord : carsrecordList){
            CarsrecordVo carsrecordVo = new CarsrecordVo();
            BeanUtils.copyProperties(carsrecord,carsrecordVo);
            carsrecordVo.setCarName(iCarsService.getById(carsrecord.getCarId()).getCarName());
            carsrecordVo.setCarBackTime(null == carsrecord.getCarBackTime() ? null:TimeUtil.stampToDate(carsrecord.getCarBackTime()));
            carsrecordVo.setCarUseTime(null == carsrecord.getCarUseTime() ? null:TimeUtil.stampToDate(carsrecord.getCarUseTime()));
            carsrecordVoList.add(carsrecordVo);
        }
        return carsrecordVoList;
    }
}
