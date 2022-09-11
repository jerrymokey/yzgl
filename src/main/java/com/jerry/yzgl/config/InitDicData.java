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

        dicitemService.saveBatch(dicitemList);
    }
}
