package cn.loaol.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loaol.note.entity.User;
import cn.loaol.note.service.PasswordException;
import cn.loaol.note.service.UserNotFoundException;
import cn.loaol.note.service.UserService;
import cn.loaol.note.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userservice;
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(String name,String password) {
			User user=userservice.login(name, password);
			return new JsonResult(user);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exHandler(Throwable e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
