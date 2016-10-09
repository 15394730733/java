package org.test.service;

import java.io.IOException;
import java.util.List;

import org.test.entity.Userinfo;

public interface UserinfoService {
	
	int insert(Userinfo user) throws IOException;
	
	int delete(Integer ID) throws IOException; 
	
	int update(Userinfo user) throws IOException;
	
	Userinfo Detail(Integer ID) throws IOException;
	
	List<Userinfo> getList(Integer pageNum,Integer pageSize) throws IOException;
	
	int getCounts(Userinfo user) throws IOException;
	
	
	
}
