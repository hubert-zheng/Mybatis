package com.hand.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hand.entity.MybatisTest;
import com.hand.entity.MybatisUtil;



public class Test1 {
	public static void main(String[] args) throws IOException {
//		//mybatis的配置文件
//        String resource = "conf.xml";
//        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
//        //构建sqlSession的工厂
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
//        //Reader reader = Resources.getResourceAsReader(resource); 
//        //构建sqlSession的工厂
//        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        //创建能执行映射文件中sql的sqlSession
//        SqlSession session = sessionFactory.openSession();
//        /**
//         * 映射sql的标识字符串，
//         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
//         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
//         */
//        String statement = "com.hand.entity.mybatistestMapper.getMybatisTest";//映射sql的标识字符串
//        //执行查询返回一个唯一user对象的sql
//        MybatisTest user = session.selectOne(statement, 1);
//        System.out.println(user);
	
	
		  //testAdd();
	
	}
	
	@Test
	public void testAdd(){
		SqlSession sqlSession = MybatisUtil.getSession();
		/*
		 *映射sql的标识字符串， 
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.hand.entity.mybatistestMapper.addMybatisTest";//映射sql的标识字符串
		MybatisTest mt = new MybatisTest();
		mt.setAge(20);
		mt.setName("zxxxxx");
		//执行插入操作
		int retResult = sqlSession.insert(statement,mt);
		//手动提交事务
		sqlSession.commit();
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}
	@Test
	public void testUpdate(){
		SqlSession sqlSession = MybatisUtil.getSession();
		/*
		 *映射sql的标识字符串， 
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.hand.entity.mybatistestMapper.updateMybatisTest";//映射sql的标识字符串
		MybatisTest mt = new MybatisTest();
		mt.setId(2);
		mt.setAge(23);
		mt.setName("hhhubert");
		//执行修改操作
		int retResult = sqlSession.update(statement,mt);
		sqlSession.commit();
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}
	@Test
	public void testDelete(){
		SqlSession sqlSession = MybatisUtil.getSession();
		/*
		 *映射sql的标识字符串， 
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
		 */
		 String statement = "com.hand.entity.mybatistestMapper.deleteMybatisTest";//映射sql的标识字符串
		//执行删除操作
		int retResult = sqlSession.delete(statement,3);
		sqlSession.commit();
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(retResult);
	}
	
	@Test
	 public void testGetAll(){
		SqlSession sqlSession = MybatisUtil.getSession();
		/*
		 *映射sql的标识字符串， 
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.hand.entity.mybatistestMapper.getAllMybatisTest";//映射sql的标识字符串
		//执行查询操作，将查询结果自动封装成List<User>返回
		List<MybatisTest> lstUsers = sqlSession.selectList(statement);
		//使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(lstUsers);
	}
	
}
