package com.nxd.ftt.mchelper.util;

import com.nxd.ftt.mchelper.mapper.AuthMeMapper;
import com.nxd.ftt.mchelper.entity.AuthMe;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * MapperUtil
 *
 * @author luhangqi
 * @date 2018/6/4
 */
public class MapperUtil {

    protected static <T> T getMapper(Class<T> c){
        return SqlSessionUtil.getInstance().getMapper(c);
    }

    public static void main(String[] args) {
        AuthMeMapper s = MapperUtil.getMapper(AuthMeMapper.class);
        List<AuthMe> a = s.select(new AuthMe());
        System.out.println(a.size());
    }
}
