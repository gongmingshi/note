package cn.loaol.note.test;

import org.junit.Test;

import cn.loaol.note.entity.User;
import cn.loaol.note.service.UserService;

public class UserServiceTest extends BaseTest {
	@Test
	public void testLoginService() {
		UserService uService=ctx.getBean("userService", UserService.class);
		User user =uService.login("demo", "123456");
		System.out.println(user);
	}
	
}
