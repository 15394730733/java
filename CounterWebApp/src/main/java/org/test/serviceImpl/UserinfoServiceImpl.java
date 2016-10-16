package org.test.serviceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.test.dao.UserinfoDao;
import org.test.entity.Userinfo;
import org.test.service.UserinfoService;


@Service
public class UserinfoServiceImpl implements UserinfoService {
	
	private static Logger logger = Logger.getLogger(UserinfoServiceImpl.class);
	
	@Resource
	private UserinfoDao userinfoDao;
	
	public int insert(Userinfo user) throws IOException {
		// TODO Auto-generated method stub
		
		if(user != null){
			user.setCreate_at(new Date());
			return userinfoDao.insert(user);
		}
		logger.info("insert方法传入参数出错");
		return 0;
	}

	public int delete(Integer ID) throws IOException {
		// TODO Auto-generated method stub
		if(ID != null){
			return userinfoDao.delete(ID);
		}
		logger.info("delete方法不能传入为空的id");
		return 0;
	}

	public int update(Userinfo user) throws IOException {
		// TODO Auto-generated method stub
		if(user.getID() != null){
			user.setUpdate_at(new Date());
			return userinfoDao.update(user);
		}
		logger.info("update方法传入的对象id不能为空");
	    return 0;
	}

	public Userinfo Detail(Integer ID) throws IOException {
		// TODO Auto-generated method stub
		if(ID != null){
			return userinfoDao.Detail(ID);	
		}
		logger.info("detail方法传入的id不能为空");
		return null;
	}

	public List<Userinfo> getList(Integer pageNum, Integer pageSize) throws IOException {
		// TODO Auto-generated method stub
		if(pageNum != null&& pageSize != null){	
			return userinfoDao.List(pageNum, pageSize);
		}else {
			return userinfoDao.List();
		}
	}

	public int getCounts(Userinfo user) throws IOException {
		// TODO Auto-generated method stub
		return userinfoDao.getCounts(user);	
	}
	
	

}
