package com.nxd.ftt.mchelper.util;

import com.nxd.ftt.mchelper.entity.AuthMe;
import com.nxd.ftt.mchelper.entity.server.ServerInfo;
import com.nxd.ftt.mchelper.mapper.AuthMeMapper;
import com.nxd.ftt.mchelper.util.authme.HashUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
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
     *
     * @return
     */
    public static List<AuthMe> listAuthMeInfo() throws SQLException {
        AuthMeMapper authMeMapper = MapperUtil.getMapper(AuthMeMapper.class);
        List<AuthMe> list = authMeMapper.select(new AuthMe());
        return list;
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public static AuthMe login(String username, String password) throws SQLException {
        AuthMeMapper authMeMapper = MapperUtil.getMapper(AuthMeMapper.class);
        String pass = authMeMapper.selectPass(username.toLowerCase());
        MapperUtil.close();
        String newPass = HashUtil.computeSHA256Hash(password, HashUtil.getSalt(pass));
        if (newPass != null && newPass.equals(pass)) {
            return authMeMapper.login(new AuthMe(username.toLowerCase(), password));
        }
        throw new NullPointerException("用户不存在");
    }

    public static ServerInfo getServerInfo() {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("mc12.icraft.cc",42460);
        ServerUtil serverUtil = new ServerUtil();
        serverUtil.setAddress(inetSocketAddress);
        return serverUtil.fetchData();
    }

}
