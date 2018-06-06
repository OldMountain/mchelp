package com.nxd.ftt.mchelper.mapper;

import com.nxd.ftt.mchelper.entity.AuthMe;

import java.util.List;

/**
 * AuthMeDao
 *
 * @author luhangqi
 * @date 2018/06/04
 */
public interface AuthMeMapper {

    /**
     * 查询
     *
     * @param authMe
     * @return
     */
    List<AuthMe> select(AuthMe authMe);

    /**
     * username，password必填，验证登录
     *
     * @param authMe
     * @return
     */
    AuthMe login(AuthMe authMe);

    /**
     * 查询密码获取salt
     *
     * @param username
     * @return
     */
    String selectPass(String username);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    AuthMe selectById(Integer id);

    /**
     * 批量删除
     *
     * @param id
     * @return
     */
    int batchDelete(Integer[] id);

    /**
     * 插入
     *
     * @param authMe
     * @return
     */
    int insert(AuthMe authMe);

    /**
     * 更新
     *
     * @param authMe
     * @return
     */
    int update(AuthMe authMe);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int delete(Integer id);
}