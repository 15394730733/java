package org.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.test.action.UserinfoAction;
import org.test.dao.UserinfoDao;
import org.test.entity.Userinfo;
import org.test.serviceImpl.UserinfoServiceImpl;

import junit.framework.Assert;


public class UserinfoTest {
	
	UserinfoServiceImpl uai = new UserinfoServiceImpl();
	
	@BeforeClass 
    public static void before(){  
        System.out.println("所有测试开始之前运行的内容");  
    }  
  
    @AfterClass  
    public static void after() {  
        System.out.println("所有测试运行结束之后的内容");  
    }  
    @Before  
    public void setUp() throws Exception {  
        System.out.println("一个测试开始。。");  
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("一个测试结束");  
    }  
	
	@Test
	public void testInsertnull() throws IOException {
		int result = uai.insert(null);
		Assert.assertEquals(0, result);  
	}
	
	@Test
	public void testInsert() throws IOException {
		int result = uai.insert(new Userinfo());
		Assert.assertEquals(1, result);  
	}

	@Test
	public void testDelete() throws IOException {
		Integer id = null;
		int result = uai.delete(id);
		Assert.assertEquals(0, result);  
	}

	@Test
	public void testUpdate() throws IOException {
		Userinfo user = new Userinfo();
		user.setID(3);
		user.setCreate_at(new Date());
		int result = uai.update(user);
		Assert.assertEquals(1, result); 
	}

	@Test
	public void testDetail() throws IOException {
		Integer id = 2;
		Userinfo user = uai.Detail(id);
		Assert.assertEquals(id,user.getID()); 
		
	}

	@Test
	public void testList() throws IOException {
		Integer pageNum = 0;
		Integer pageSize = 10;
		List<Userinfo> lu = uai.getList(pageNum,pageSize);
		
	}
	
	@Test
	public void testListwithout() throws IOException {
		Integer pageNum = null;
		Integer pageSize = null;
		List<Userinfo> lu = uai.getList(pageNum,pageSize);
		for(Userinfo U : lu){
			Userinfo user = uai.Detail(U.getID());
			Assert.assertEquals(U.getCreate_at(), user.getCreate_at()); 
		}
	}

}
