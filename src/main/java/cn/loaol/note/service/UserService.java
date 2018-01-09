package cn.loaol.note.service;

import cn.loaol.note.entity.User;

public interface UserService {
	public User login(String name,String password)
	throws UserNotFoundException,PasswordException;
}
