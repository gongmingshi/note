package cn.loaol.note.dao;

import cn.loaol.note.entity.User;

public interface UserDao {
	User findUserByName(String name);
}
