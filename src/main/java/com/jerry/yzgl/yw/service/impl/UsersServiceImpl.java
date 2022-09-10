package com.jerry.yzgl.yw.service.impl;

import com.jerry.yzgl.yw.domain.Users;
import com.jerry.yzgl.yw.dao.UsersDao;
import com.jerry.yzgl.yw.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jerry
 * @since 2022-09-10
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersDao, Users> implements IUsersService {

}
