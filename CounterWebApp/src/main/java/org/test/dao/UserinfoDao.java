package org.test.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import org.test.entity.Userinfo;
import org.test.mapper.UserinfoMapper;

@Repository
public class UserinfoDao {
	
	private static String resource = "mybatis-config.xml";
	
	private SqlSession getSession() throws IOException{
		InputStream inputStream=null;
		inputStream = Resources.getResourceAsStream(this.resource);	
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		return ssf.openSession();
	}
	
	public int insert(Userinfo user) throws IOException{
		Integer num = null;
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		   num = um.insert(user);
		   session.commit();
		} 
		finally {
		  session.close();
		}
		return num;
	} 	
	public int delete(int ID) throws IOException{
		Integer num = null;
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		   num = um.delete(ID);
		   session.commit();
		} 
		finally {
		  session.close();
		}
		return num;
	} 
	public int update(Userinfo user) throws IOException{
		Integer num = null;
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		   num = um.update(user);
		   session.commit();
		} 
		finally {
		  session.close();
		}
		return num;
	} 
	public Userinfo Detail(int ID) throws IOException{
		Userinfo user = new Userinfo();
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		   user = um.detail(ID);
		   session.commit();
		} 
		finally {
		  session.close();
		}
		return user;
	} 
	public List<Userinfo> List(int pageNum,int pageSize) throws IOException{
		List<Userinfo> user = new ArrayList<Userinfo>();
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		  int page = pageNum*10;
		  user = um.list(page, pageSize);
		  session.commit();
		} 
		finally {
		  session.close();
		}
		return user;
	} 
	public List<Userinfo> List() throws IOException{
		List<Userinfo> user = new ArrayList<Userinfo>();
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		  user = um.listAll();
		  session.commit();
		} 
		finally {
		  session.close();
		}
		return user;
	} 
	public int getCounts(Userinfo user) throws IOException{
		Integer num = null;
		SqlSession session = getSession();
		try {
		  UserinfoMapper um = session.getMapper(UserinfoMapper.class);
		   num = um.getCounts(user);
		   session.commit();
		} 
		finally {
		  session.close();
		}
		return num;
	}
}
