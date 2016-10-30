package org.test.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.entity.Userinfo;
import org.test.serviceImpl.UserinfoServiceImpl;
import org.test.util.StringUtil;



@Controller
@RequestMapping(value="/user")
public class UserinfoAction {
	
	
	private static Logger logger = Logger.getLogger(UserinfoAction.class);
	@Autowired
	private UserinfoServiceImpl us;
	
	@RequestMapping(value="/goadd")
	public String goAdd(){
		return "insert";
	}

	
	@RequestMapping(value="/add")
	public String insert(HttpServletRequest request,Userinfo user){
		String msg = "请填写个人信息后再提交";
		if(user != null){
			String account = user.getAccount();//request.getParameter("account");
			String password =user.getPassword(); //request.getParameter("password");
			logger.info("该用户设置的acount为 {"+account+"},密码password为 {"+password+"}");
			msg = "账号与密码必填";
			if(StringUtil.isNotEmpty(account)&&StringUtil.isNotEmpty(password)){
				int num = 0;
				msg = "添加方法出错，请稍后再试";
				try {
					user.setCreate_at(new Date());
					num = us.insert(user);
					if(num == 1){
						request.setAttribute("success", "添加成功");
						return "success";
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("action中的添加方法出错");
					logger.error(e);
				}
			}
		}
		request.setAttribute("error",msg);
		return "error";
	}
	
	@RequestMapping(value="/delete/{ID}/")
	public String delete(@PathVariable String ID,HttpServletRequest request){
		String msg = "请填写被删除的id";
		logger.info("管理员删除的ID是 {"+ID+"}");
		if(StringUtil.isNotEmpty(ID)){
			msg = "删除失败，请稍后再试";
			Integer id = Integer.parseInt(ID);
			int num = 0;
			try {
				num = us.delete(id);
				if(num != 0){
					request.setAttribute("success", "删除成功");
					return "success";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的删除方法报错");
				logger.error(e);
			}
		}
		request.setAttribute("error", msg);
		return "error";
	}
	
	@RequestMapping(value="/update")
	public String update(HttpServletRequest request,Userinfo user){
		String msg = "请指定被修改的用户";
		logger.info("用户名为account {　" + user.getAccount()+ "　}  "
				+ "密码 改为 password {" +user.getPassword()+ "},"
				+ "他的id为 { " + user.getID() + " }");
		if(StringUtil.isNotEmpty(user.getID().toString())){
			int num = 0;
			msg = "修改失败，请稍后再试"; 
			try {
				user.setUpdate_at(new Date());
				num = us.update(user);
				if(num == 1){
					request.setAttribute("success", "修改成功");
					return "success";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的修改方法报错");
				logger.error(e);
			}
		}
		request.setAttribute("error", msg);
		return "error";
	}
	
	@RequestMapping(value="/detail/{ID}/")
	public String detail(@PathVariable String ID,HttpServletRequest request){
		String msg = "请指定查看详情的id";
		logger.info("查询ID为 { " + ID + " }的用户详情");
		if(StringUtil.isNotEmpty(ID)){
			msg = "未查询到指定id的信息，请修改条件或稍后再试";
			Integer id = Integer.parseInt(ID);
			Userinfo user = null;
			try {
				user = us.Detail(id);
				if(user != null){
					request.setAttribute("user", user);
					return "detail";
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的查询方法报错");
				logger.error(e);
			}
		}
		request.setAttribute("error",msg);
		return "error";
	}
	
	@RequestMapping(value="/goupdate/{ID}/")
	public String goupdate(@PathVariable String ID,HttpServletRequest request){
		String msg = "请指定被修改的id";
		logger.info("查询ID为 { " + ID + " }的用户详情");
		if(StringUtil.isNotEmpty(ID)){
			msg = "未查到该id的详细信息，请修改条件或稍后再试";
			Integer id = Integer.parseInt(ID);
			Userinfo user = null;
			try {
				user = us.Detail(id);
				if(user != null){
					request.setAttribute("user", user);
					return "update";
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的去修改方法报错");
				logger.error(e);
			}
		}
		request.setAttribute("error",msg);
		return "error";
	}
	
	
	@RequestMapping(value="/getlist")
	public String getList(HttpServletRequest request){
		String msg = "未查到指定数据，请稍后再试";
		Integer pn = null;
		Integer ps = null;
		List<Userinfo> lu = null;
		try {
			lu = us.getList(pn, ps);
			request.setAttribute("lu", lu);
			return "list";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("action中的查询列表方法报错");
			logger.error(e);
		}
		request.setAttribute("error",msg);
		return "error";
	}


	@RequestMapping(value="/getCounts")
	public String getCounts(HttpServletRequest request){
		String msg = "未查到指定数据，请稍后再试";
		Userinfo user = new Userinfo();
		int num = 0;
		try {
			num = us.getCounts(user);
			request.setAttribute("listNum", "总共" +num+"条记录");
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("action中的查询总记录条数方法报错");
			logger.error(e);
		}
		request.setAttribute("error",msg);
		return "error";
	}
}
