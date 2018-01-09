package cn.loaol.note.service.impl;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.loaol.note.dao.UserDao;
import cn.loaol.note.entity.User;
import cn.loaol.note.service.PasswordException;
import cn.loaol.note.service.UserNotFoundException;
import cn.loaol.note.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserDao dao;
	public User login(String name, String password) throws UserNotFoundException, PasswordException {
		String salt="gongmingshi";		
		if(password==null||password.trim().isEmpty()) throw new PasswordException("密码空");
		if(name==null||name.trim().isEmpty()) throw new UserNotFoundException("用户名空");
		String pwd=DigestUtils.md2Hex(salt+password);
		User user=dao.findUserByName(name);
		if(user==null) throw new UserNotFoundException("名称错误！");
		if(!pwd.equals(user.getPassword())) throw new PasswordException("密码错误！");
		return user;
	}

}
