package org.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.test.entity.Userinfo;


public interface UserinfoMapper  {
	
	 int insert(Userinfo user);
	 
	 int delete(int ID);
	 
	 int update(Userinfo user);
	 
	 Userinfo detail(int ID);
	 
	 List<Userinfo> list(@Param("page")int page,@Param("pageSize")int pageSize);
	 
	 List<Userinfo> listAll();
	 
	 int getCounts(Userinfo user);
}
