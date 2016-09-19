package com.vienna.controllers;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vienna.domain.tables.pojos.TUser;
import com.vienna.serivces.UserService;
import com.vienna.utils.Md5Util;

@Controller
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	 @Autowired
	 UserService userService;
	 
	 /**
	  * 登录逻辑
	  * @author ys
	  * @createTime 2016年9月19日
	  * @description:
	  */
	@RequestMapping("/user/login.html")
	@ResponseBody
    public String login(HttpServletRequest request,TUser u){
		TUser t=null;
		try {
			t = userService.login(u.getName(),Md5Util.sign(u.getPassword(), "UTF-8") );
		} catch (Exception e) {
			logger.error("MD5加密失败",e);
			return "fail";
		}
		if(t!=null){
			request.getSession().setMaxInactiveInterval(20);
			request.getSession().setAttribute("user", t);
			System.out.println(t.getName());
		}
    	return t!=null?"success":"fail";
    }
	
	/**
	 * 注册或者是修改\取决于是否传有id
	 * @author ys
	 * @createTime 2016年9月19日
	 * @description:
	 */
	@RequestMapping("/user/saveOrUpdate.html")
	@ResponseBody
	public String  saveUser(TUser u){
		if(u.getId()==null){
			try {
				String pwd = Md5Util.sign(u.getPassword(), "UTF-8");
				u.setPassword(pwd);
			} catch (Exception e) {
				logger.error("MD5加密失败",e);
				return "fail";
			}
		}
		int i = userService.saveOrUpdate(u);
		return i>0?"success":"fail";
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping("/user/delete.html")
	@ResponseBody
	public String  delete(TUser u){
		u.setStatus(false);
		int i = userService.saveOrUpdate(u);
		return i>0?"success":"fail";
	}
	
	/**
	 * session测试
	 */
	@RequestMapping("/user/session.html")
	@ResponseBody
	public String testSeesion(HttpServletRequest request){
		TUser user = (TUser) request.getSession().getAttribute("user");
		return user.getName();
	}
	
}
