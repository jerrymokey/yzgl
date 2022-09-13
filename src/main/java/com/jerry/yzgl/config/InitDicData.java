/*
package com.jerry.yzgl.config;

import com.jerry.yzgl.util.UUIDUtils;
import com.jerry.yzgl.yw.controller.AnimalsController;
import com.jerry.yzgl.yw.domain.Dic;
import com.jerry.yzgl.yw.domain.Dicitem;
import com.jerry.yzgl.yw.service.IDicService;
import com.jerry.yzgl.yw.service.IDicitemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDicData implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(InitDicData.class);
    @Autowired
    private IDicitemService dicitemService;
    @Autowired
    private IDicService dicService;

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("项目初始化完毕");

        if (!checkDic()) {
            initDic();
            logger.info("初始化字典项");
        }
        if (!checkDicItem()) {
            initDicItem();
            logger.info("初始化字典数据");
        }
        logger.info("字典加载初始化完毕");
    }

    //检查本地库dic有无数据
    boolean checkDic() {
        List<Dic> dicList = dicService.list();
        if (dicList == null || dicList.size() <= 0) {
            return false;//无
        } else {
            return true;//有
        }
    }

    //
    boolean checkDicItem() {
        List<Dicitem> dicitemList = dicitemService.list();
        if (dicitemList == null || dicitemList.size() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    //加载基本的字典项
    void initDic() {
        List<Dic> dicList = new ArrayList<>();

        Dic dic = new Dic();
        dic.setId(UUIDUtils.getUUID());
        dic.setDicName("牛圈栏位");
        dic.setDicCode("location");
        dicList.add(dic);

        Dic dic1 = new Dic();
        dic1.setId(UUIDUtils.getUUID());
        dic1.setDicName("牲畜类型");
        dic1.setDicCode("type");
        dicList.add(dic1);

        Dic dic2 = new Dic();
        dic2.setId(UUIDUtils.getUUID());
        dic2.setDicName("牲畜性别");
        dic2.setDicCode("sex");
        dicList.add(dic2);

        Dic dic3 = new Dic();
        dic3.setId(UUIDUtils.getUUID());
        dic3.setDicName("牲畜健康状况");
        dic3.setDicCode("health");
        dicList.add(dic3);

        Dic dic4 = new Dic();
        dic4.setId(UUIDUtils.getUUID());
        dic4.setDicName("车辆类型");
        dic4.setDicCode("carType");
        dicList.add(dic4);

        Dic dic5 = new Dic();
        dic5.setId(UUIDUtils.getUUID());
        dic5.setDicName("车辆油料型号");
        dic5.setDicCode("carOil");
        dicList.add(dic5);

        Dic dic6 = new Dic();
        dic6.setId(UUIDUtils.getUUID());
        dic6.setDicName("车辆派遣类型");
        dic6.setDicCode("carUseType");
        dicList.add(dic6);

        Dic dic7 = new Dic();
        dic7.setId(UUIDUtils.getUUID());
        dic7.setDicName("拉回车辆运载情况");
        dic7.setDicCode("carStatus");
        dicList.add(dic7);

        dicService.saveBatch(dicList);
    }

    void initDicItem() {

        List<Dicitem> dicitemList = new ArrayList<>();

        Dicitem dicitem = new Dicitem();
        dicitem.setId(UUIDUtils.getUUID());
        dicitem.setDicitemCode("location");
        dicitem.setDicitemName("一号圈");
        dicitemList.add(dicitem);

        Dicitem dicitem1 = new Dicitem();
        dicitem1.setId(UUIDUtils.getUUID());
        dicitem1.setDicitemCode("location");
        dicitem1.setDicitemName("二号圈");
        dicitemList.add(dicitem1);

        Dicitem dicitem2 = new Dicitem();
        dicitem2.setId(UUIDUtils.getUUID());
        dicitem2.setDicitemCode("location");
        dicitem2.setDicitemName("三号圈");
        dicitemList.add(dicitem2);

        Dicitem dicitem3 = new Dicitem();
        dicitem3.setId(UUIDUtils.getUUID());
        dicitem3.setDicitemCode("location");
        dicitem3.setDicitemName("四号圈");
        dicitemList.add(dicitem3);

        Dicitem dicitem4 = new Dicitem();
        dicitem4.setId(UUIDUtils.getUUID());
        dicitem4.setDicitemCode("type");
        dicitem4.setDicitemName("牛");
        dicitemList.add(dicitem4);

        Dicitem dicitem5 = new Dicitem();
        dicitem5.setId(UUIDUtils.getUUID());
        dicitem5.setDicitemCode("type");
        dicitem5.setDicitemName("驴");
        dicitemList.add(dicitem5);

        Dicitem dicitem6 = new Dicitem();
        dicitem6.setId(UUIDUtils.getUUID());
        dicitem6.setDicitemCode("type");
        dicitem6.setDicitemName("骡子");
        dicitemList.add(dicitem6);

        Dicitem dicitem7 = new Dicitem();
        dicitem7.setId(UUIDUtils.getUUID());
        dicitem7.setDicitemCode("type");
        dicitem7.setDicitemName("马");
        dicitemList.add(dicitem7);

        Dicitem dicitem8 = new Dicitem();
        dicitem8.setId(UUIDUtils.getUUID());
        dicitem8.setDicitemCode("sex");
        dicitem8.setDicitemName("公");
        dicitemList.add(dicitem8);

        Dicitem dicitem9 = new Dicitem();
        dicitem9.setId(UUIDUtils.getUUID());
        dicitem9.setDicitemCode("sex");
        dicitem9.setDicitemName("母");
        dicitemList.add(dicitem9);

        Dicitem dicitem34 = new Dicitem();
        dicitem34.setId(UUIDUtils.getUUID());
        dicitem34.setDicitemCode("sex");
        dicitem34.setDicitemName("无");
        dicitemList.add(dicitem34);


        Dicitem dicitem10 = new Dicitem();
        dicitem10.setId(UUIDUtils.getUUID());
        dicitem10.setDicitemCode("health");
        dicitem10.setDicitemName("健康");
        dicitemList.add(dicitem10);

        Dicitem dicitem11 = new Dicitem();
        dicitem11.setId(UUIDUtils.getUUID());
        dicitem11.setDicitemCode("health");
        dicitem11.setDicitemName("残疾");
        dicitemList.add(dicitem11);

        Dicitem dicitem12 = new Dicitem();
        dicitem12.setId(UUIDUtils.getUUID());
        dicitem12.setDicitemCode("health");
        dicitem12.setDicitemName("死亡");
        dicitemList.add(dicitem12);

        Dicitem dicitem13 = new Dicitem();
        dicitem13.setId(UUIDUtils.getUUID());
        dicitem13.setDicitemCode("health");
        dicitem13.setDicitemName("生病");
        dicitemList.add(dicitem13);

        Dicitem dicitem14 = new Dicitem();
        dicitem14.setId(UUIDUtils.getUUID());
        dicitem14.setDicitemCode("carType");
        dicitem14.setDicitemName("小型车");
        dicitemList.add(dicitem14);

        Dicitem dicitem15 = new Dicitem();
        dicitem15.setId(UUIDUtils.getUUID());
        dicitem15.setDicitemCode("carType");
        dicitem15.setDicitemName("中型车");
        dicitemList.add(dicitem15);

        Dicitem dicitem16 = new Dicitem();
        dicitem16.setId(UUIDUtils.getUUID());
        dicitem16.setDicitemCode("carType");
        dicitem16.setDicitemName("大型车");
        dicitemList.add(dicitem16);

        Dicitem dicitem17 = new Dicitem();
        dicitem17.setId(UUIDUtils.getUUID());
        dicitem17.setDicitemCode("carOil");
        dicitem17.setDicitemName("92号汽油");
        dicitemList.add(dicitem17);

        Dicitem dicitem18 = new Dicitem();
        dicitem18.setId(UUIDUtils.getUUID());
        dicitem18.setDicitemCode("carOil");
        dicitem18.setDicitemName("95号汽油");
        dicitemList.add(dicitem18);

        Dicitem dicitem19 = new Dicitem();
        dicitem19.setId(UUIDUtils.getUUID());
        dicitem19.setDicitemCode("carOil");
        dicitem19.setDicitemName("98号汽油");
        dicitemList.add(dicitem19);

        Dicitem dicitem20 = new Dicitem();
        dicitem20.setId(UUIDUtils.getUUID());
        dicitem20.setDicitemCode("carOil");
        dicitem20.setDicitemName("10#柴油");
        dicitemList.add(dicitem20);

        Dicitem dicitem21 = new Dicitem();
        dicitem21.setId(UUIDUtils.getUUID());
        dicitem21.setDicitemCode("carOil");
        dicitem21.setDicitemName("5＃柴油");
        dicitemList.add(dicitem21);

        Dicitem dicitem22 = new Dicitem();
        dicitem22.setId(UUIDUtils.getUUID());
        dicitem22.setDicitemCode("carOil");
        dicitem22.setDicitemName("0＃柴油");
        dicitemList.add(dicitem22);

        Dicitem dicitem23 = new Dicitem();
        dicitem23.setId(UUIDUtils.getUUID());
        dicitem23.setDicitemCode("carOil");
        dicitem23.setDicitemName("-10＃柴油");
        dicitemList.add(dicitem23);

        Dicitem dicitem24 = new Dicitem();
        dicitem24.setId(UUIDUtils.getUUID());
        dicitem24.setDicitemCode("carOil");
        dicitem24.setDicitemName("-20＃柴油");
        dicitemList.add(dicitem24);

        Dicitem dicitem25 = new Dicitem();
        dicitem25.setId(UUIDUtils.getUUID());
        dicitem25.setDicitemCode("carOil");
        dicitem25.setDicitemName("-35＃柴油");
        dicitemList.add(dicitem25);

        Dicitem dicitem26 = new Dicitem();
        dicitem26.setId(UUIDUtils.getUUID());
        dicitem26.setDicitemCode("carOil");
        dicitem26.setDicitemName("-50＃柴油");
        dicitemList.add(dicitem26);

        Dicitem dicitem27 = new Dicitem();
        dicitem27.setId(UUIDUtils.getUUID());
        dicitem27.setDicitemCode("carUseType");
        dicitem27.setDicitemName("购买牲畜");
        dicitemList.add(dicitem27);

        Dicitem dicitem28 = new Dicitem();
        dicitem28.setId(UUIDUtils.getUUID());
        dicitem28.setDicitemCode("carUseType");
        dicitem28.setDicitemName("运送牲畜");
        dicitemList.add(dicitem28);

        Dicitem dicitem29 = new Dicitem();
        dicitem29.setId(UUIDUtils.getUUID());
        dicitem29.setDicitemCode("carUseType");
        dicitem29.setDicitemName("家用");
        dicitemList.add(dicitem29);

        Dicitem dicitem30 = new Dicitem();
        dicitem30.setId(UUIDUtils.getUUID());
        dicitem30.setDicitemCode("carUseType");
        dicitem30.setDicitemName("清理粪便");
        dicitemList.add(dicitem30);

        Dicitem dicitem31 = new Dicitem();
        dicitem31.setId(UUIDUtils.getUUID());
        dicitem31.setDicitemCode("carUseType");
        dicitem31.setDicitemName("重大农活");
        dicitemList.add(dicitem31);

        Dicitem dicitem32 = new Dicitem();
        dicitem32.setId(UUIDUtils.getUUID());
        dicitem32.setDicitemCode("carStatus");
        dicitem32.setDicitemName("空载");
        dicitemList.add(dicitem32);

        Dicitem dicitem33 = new Dicitem();
        dicitem33.setId(UUIDUtils.getUUID());
        dicitem33.setDicitemCode("carStatus");
        dicitem33.setDicitemName("小有收获");
        dicitemList.add(dicitem33);

        Dicitem dicitem35 = new Dicitem();
        dicitem35.setId(UUIDUtils.getUUID());
        dicitem35.setDicitemCode("carStatus");
        dicitem35.setDicitemName("满载而归");
        dicitemList.add(dicitem35);

        dicitemService.saveBatch(dicitemList);
    }
}
*/
