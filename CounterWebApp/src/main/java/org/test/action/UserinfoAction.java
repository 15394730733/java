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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.entity.Userinfo;
import org.test.serviceImpl.UserinfoServiceImpl;
import org.test.util.StringUtil;

@Controller
@RequestMapping(value="/user")
public class UserinfoAction {
	
	
	private static Logger logger = Logger.getLogger(UserinfoAction.class);
	@Resource
	private UserinfoServiceImpl us;
	
	@RequestMapping(value="/insert")
	public String insert(HttpServletRequest request,Model model){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		logger.info("###########acount {"+account+"},password {"+password+"}#########");
		if(StringUtil.isNotEmpty(account)&&StringUtil.isNotEmpty(password)){
			Userinfo user = new Userinfo();
			user.setAccount(account);
			user.setPassword(password);
			int num = 0;
			try {
				num = us.insert(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("添加方法出错");
				logger.error(e);
			}
			if(num != 1){
				model.addAttribute("error", "添加失败");
				return "error";
			}else {
				model.addAttribute("success", "添加成功");
				return "success";
			}
		}else {
			model.addAttribute("error", "账号密码必填");
			return "error";
		}
	}
	@RequestMapping(value="/delete/{ID}")
	public String delete(
			@PathVariable String ID,
			Model model){
		logger.info("#############ID {"+ID+"}############");
		if(StringUtil.isNotEmpty(ID)){
			Integer id = Integer.parseInt(ID);
			int num = 0;
			try {
				num = us.delete(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("删除方法出错");
				logger.error(e);
			}
			if(num != 0){
				model.addAttribute("error", "删除失败");
				return "error";
			}else {
				model.addAttribute("success", "删除成功");
				return "success";
			}
		}else {
			model.addAttribute("error", "没有指定ID");
			return "error";
		}
	}
	@RequestMapping(value="/update")
	public String update(HttpServletRequest request,Model model){
		String password = request.getParameter("password");
		String id = request.getParameter("ID");
		logger.info("###########password {"+password+"},ID {"+id+"}###########");
		Userinfo user = new Userinfo();
		if(StringUtil.isNotEmpty(id)){
			user.setPassword(password);
			user.setID(Integer.parseInt(id));
			int num = 0;
			try {
				num = us.update(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("修改方法出错");
				logger.error(e);
			}
			if(num == 1){
				model.addAttribute("success", "修改成功");
				return "success";
			}else {
				model.addAttribute("error", "修改失败");
				return "error";
			}
		}else {
			model.addAttribute("error", "被修改对象的id不能为空");
			return "error";
		}
	}
	@RequestMapping(value="/detail/{ID}")
	public String detail(
			@PathVariable String ID,
			Model model){
		logger.info("#########ID {"+ID+"}##############");
		if(StringUtil.isNotEmpty(ID)){
			Integer id = Integer.parseInt(ID);
			Userinfo user = null;
			try {
				user = us.Detail(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("详细方法出错");
				logger.error(e);
			}
			if(user != null){
				model.addAttribute("user", user);
				return "detail";
			}else {  
				model.addAttribute("error", "未查到指定数据");
				return "error";
			}
		}else {
			model.addAttribute("error", "没有指定ID");
			return "error";
		}
	}
	@RequestMapping(value="/getlist")
	public String getList(
			@RequestParam(value="pageNum", required=false)String pageNum,
			@RequestParam(value="pageSize", required=false)String pageSize,
				Model model){
		logger.info("##########pageNum {"+pageNum+"},pageSize {"+pageSize+"}########");
		if(StringUtil.isNotEmpty(pageNum)&&StringUtil.isNotEmpty(pageSize)){
			Integer pn = Integer.parseInt(pageNum);
			Integer ps = Integer.parseInt(pageSize);
			List<Userinfo> lu = null;
			try {
				lu = us.getList(pn, ps);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("列表方法出错");
				logger.error(e);
			}
			model.addAttribute("lu", lu);
			return "list";
		}else {
			model.addAttribute("error", "必须指定页码和页面大小");
			return "error";
		}
	}
	@RequestMapping(value="/getCounts")
	public String getCounts(Model model){
		Userinfo user = new Userinfo();
		int num = 0;
		try {
			num = us.getCounts(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("总记录条数方法出错");
			logger.error(e);
		}
		model.addAttribute("listNum", num);
		return "success";
	}
}
