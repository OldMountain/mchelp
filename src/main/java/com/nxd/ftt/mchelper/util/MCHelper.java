package com.nxd.ftt.mchelper.util;

import com.github.pagehelper.PageHelper;
import com.nxd.ftt.mchelper.entity.AuthMe;
import com.nxd.ftt.mchelper.mapper.AuthMeMapper;

import java.util.List;

/**
 * MCHelper
 *
 * @author luhangqi
 * @date 2018/6/5
 */
public class MCHelper {

    /**
     * 获取登录信息
     * @return
     */
    public static List<AuthMe> getAuthMe(){
        AuthMeMapper authMeMapper = MapperUtil.getMapper(AuthMeMapper.class);
        List<AuthMe> list = authMeMapper.select(new AuthMe());
        return list;
    }
}
