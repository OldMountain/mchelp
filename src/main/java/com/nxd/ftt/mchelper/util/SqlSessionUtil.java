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

    private SqlSessionUtil() {
    }

    public static SqlSession getInstance() {
        try {
            return SqlSessionUtilSingle.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class SqlSessionUtilSingle {
        private static SqlSession sqlSession;

        public static SqlSession getSqlSession() throws IOException {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        }

    }
}
