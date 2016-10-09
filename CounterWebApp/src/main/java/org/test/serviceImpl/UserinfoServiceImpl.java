package org.test.serviceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.test.action.UserinfoAction;
import org.test.dao.UserinfoDao;
import org.test.entity.Userinfo;
import org.test.service.UserinfoService;
import org.test.util.StringUtil;

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
		}else {
			logger.info("添加对象不能为空");
			return 0;
		}
	}

	public int delete(Integer ID) throws IOException {
		// TODO Auto-generated method stub
		if(ID != null){
			return userinfoDao.delete(ID);
		}else {
			logger.info("id不能为空");
			return 0;
		}
	}

	public int update(Userinfo user) throws IOException {
		// TODO Auto-generated method stub
		if(user.getID() != null){
			user.setUpdate_at(new Date());
			return userinfoDao.update(user);
		}else {
			logger.info("不能传入id为空的user对象");
			return 0;
		}
	}

	public Userinfo Detail(Integer ID) throws IOException {
		// TODO Auto-generated method stub
		if(ID != null){
			return userinfoDao.Detail(ID);	
		}else {
			logger.info("id为空无法查询");
			return null;
		}
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
