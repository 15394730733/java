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
				logger.error("��ӷ�������");
				logger.error(e);
			}
			if(num != 1){
				model.addAttribute("error", "���ʧ��");
				return "error";
			}else {
				model.addAttribute("success", "��ӳɹ�");
				return "success";
			}
		}else {
			model.addAttribute("error", "�˺��������");
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
				logger.error("ɾ����������");
				logger.error(e);
			}
			if(num != 0){
				model.addAttribute("error", "ɾ��ʧ��");
				return "error";
			}else {
				model.addAttribute("success", "ɾ���ɹ�");
				return "success";
			}
		}else {
			model.addAttribute("error", "û��ָ��ID");
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
				logger.error("�޸ķ�������");
				logger.error(e);
			}
			if(num == 1){
				model.addAttribute("success", "�޸ĳɹ�");
				return "success";
			}else {
				model.addAttribute("error", "�޸�ʧ��");
				return "error";
			}
		}else {
			model.addAttribute("error", "���޸Ķ����id����Ϊ��");
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
				logger.error("��ϸ��������");
				logger.error(e);
			}
			if(user != null){
				model.addAttribute("user", user);
				return "detail";
			}else {  
				model.addAttribute("error", "δ�鵽ָ������");
				return "error";
			}
		}else {
			model.addAttribute("error", "û��ָ��ID");
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
				logger.error("�б�������");
				logger.error(e);
			}
			model.addAttribute("lu", lu);
			return "list";
		}else {
			model.addAttribute("error", "����ָ��ҳ���ҳ���С");
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
			logger.error("�ܼ�¼������������");
			logger.error(e);
		}
		model.addAttribute("listNum", num);
		return "success";
	}
}
