package com.nxd.ftt.mchelper.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionUtil
 *
 * @author luhangqi
 * @date 2018/6/4
 */
public class SqlSessionUtil {

    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    private SqlSessionUtil() {
    }

    public static SqlSession getInstance() {
        try {
            if (sqlSession == null) {
                sqlSession = SqlSessionUtilSingle().openSession();
            }
            return sqlSession;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SqlSessionFactory SqlSessionUtilSingle() throws IOException {
        if (sqlSessionFactory == null) {
            synchronized (SqlSessionUtil.class) {
                if (sqlSessionFactory == null) {
                    String resource = "mybatis-config.xml";
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                }
            }
        }
        return sqlSessionFactory;
    }

    public static void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
