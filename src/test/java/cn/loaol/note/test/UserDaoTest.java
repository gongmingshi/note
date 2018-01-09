package cn.loaol.note.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.loaol.note.dao.UserDao;
import cn.loaol.note.entity.User;

public class UserDaoTest extends BaseTest{
	ClassPathXmlApplicationContext ctx;
	@Test
	public void testFindUserByName() {
		String name="pc";
		UserDao dao=ctx.getBean("userDao", UserDao.class);
		User user =dao.findUserByName(name);
		System.out.println(user);
	}
	
}
