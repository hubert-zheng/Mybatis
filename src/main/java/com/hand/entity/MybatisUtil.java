package com.hand.entity;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory;
    static{
        String configName="conf.xml";
        InputStream in;
        try {
            
            in=Resources.getResourceAsStream(configName);
            factory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //获取SqlSession
    public static SqlSession getSession(){
        
        
        return factory.openSession();        
        
    }
    //关闭SqlSession
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}