package cn.loaol.note.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class Md5Test {
	@Test
	public void test() {
		String str="123123";
		String salt="gongmingshi";
		String md5=DigestUtils.md5Hex(salt+str);
		System.out.println(md5);
	}
}
