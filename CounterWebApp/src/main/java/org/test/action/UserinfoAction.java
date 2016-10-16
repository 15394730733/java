package org.test.action;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@RequestMapping(value="/insert")
	public String insert(HttpServletRequest request,Model model,@ModelAttribute Userinfo user){
		String account = user.getAccount();
		String password = user.getPassword();
		logger.info("该用户设置的acount为 {"+account+"},密码password为 {"+password+"}");
		if(StringUtil.isNotEmpty(account)&&StringUtil.isNotEmpty(password)){
			int num = 0;
			try {
				user.setCreate_at(new Date());
				num = us.insert(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的添加方法出错");
				logger.error(e);
			}
			if(num != 1){
				model.addAttribute("error", "添加失败");
				return "error";
			}
			model.addAttribute("success", "添加成功");
			return "success";
		}
		model.addAttribute("error", "账号密码必填");
		return "error";
	}
	
	@RequestMapping(value="/delete/{ID}")
	public String delete(
			@PathVariable String ID,
			Model model){
		logger.info("管理员删除的ID是 {"+ID+"}");
		if(StringUtil.isNotEmpty(ID)){
			Integer id = Integer.parseInt(ID);
			int num = 0;
			try {
				num = us.delete(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的删除方法报错");
				logger.error(e);
			}
			if(num != 0){
				model.addAttribute("error", "删除失败");
				return "error";
			}
			model.addAttribute("success", "删除成功");
			return "success";
		}
		model.addAttribute("error", "请先选择要删除的id");
		return "error";
	}
	
	@RequestMapping(value="/update")
	public String update(HttpServletRequest request,Model model,@RequestParam Userinfo user){
		logger.info("用户名为account {　" + user.getAccount()+ "　}  "
				+ "密码 改为 password {" +user.getPassword()+ "},"
				+ "他的id为 { " + user.getID() + " }");
		if(StringUtil.isNotEmpty(user.getID().toString())){
			int num = 0;
			try {
				user.setUpdate_at(new Date());
				num = us.update(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的修改方法报错");
				logger.error(e);
			}
			if(num == 1){
				model.addAttribute("success", "修改成功");
				return "success";
			}
			model.addAttribute("error", "修改失败，请稍后重试");
			return "error";
		}
		model.addAttribute("error", "请先选择需要修改的用户");
		return "error";
	}
	
	@RequestMapping(value="/detail/{ID}")
	public String detail(
			@PathVariable String ID,
			Model model){
		logger.info("查询ID为 { " + ID + " }的用户详情");
		if(StringUtil.isNotEmpty(ID)){
			Integer id = Integer.parseInt(ID);
			Userinfo user = null;
			try {
				user = us.Detail(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的查询方法报错");
				logger.error(e);
			}
			if(user != null){
				model.addAttribute("user", user);
				return "detail";
			} 
			model.addAttribute("error", "未查到指定的用户数据");
			return "error";
		}
		model.addAttribute("error", "请先选择想要查询的用户");
		return "error";
	}
	
	@RequestMapping(value="/goupdate/{ID}")
	public String goupdate(
			@PathVariable String ID,
			Model model){
		logger.info("查询ID为 { " + ID + " }的用户详情");
		if(StringUtil.isNotEmpty(ID)){
			Integer id = Integer.parseInt(ID);
			Userinfo user = null;
			try {
				user = us.Detail(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的去修改方法报错");
				logger.error(e);
			}
			if(user != null){
				model.addAttribute("user", user);
				return "update";
			} 
			model.addAttribute("error", "未查到指定的用户数据");
			return "error";
		}
		model.addAttribute("error", "请先选择想要查询的用户");
		return "error";
	}
	
	@ResponseBody
	@RequestMapping(value="/getlist/{pageNum}/{pageSize}")
	public String getList(
			@PathVariable String pageNum,
			@PathVariable String pageSize,
				Model model){
		logger.info("分页页面的页码 pageNum {"+pageNum+"},页面大小pageSize {"+pageSize+"}");
		if(StringUtil.isNotEmpty(pageNum)&&StringUtil.isNotEmpty(pageSize)){
			Integer pn = Integer.parseInt(pageNum);
			Integer ps = Integer.parseInt(pageSize);
			List<Userinfo> lu = null;
			try {
				lu = us.getList(pn, ps);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("action中的查询列表方法报错");
				logger.error(e);
			}
			model.addAttribute("lu", lu);
			return "list";
		}
		model.addAttribute("error", "请现指定页面大小和页码");
		return "error";
	}
	@RequestMapping(value="/getCounts")
	public String getCounts(Model model){
		Userinfo user = new Userinfo();
		int num = 0;
		try {
			num = us.getCounts(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("action中的查询总记录条数方法报错");
			logger.error(e);
		}
		model.addAttribute("listNum", num);
		return "success";
	}
}
