/**
 * 
 */
package Dao;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class UserDaoTest {
	@Resource
	private UserDao userDao;

	@Test
	public void test() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/jdbc.properties"));
		properties.getProperty("url");
		System.out.println(properties.getProperty("url"));
	}


	@Test
	public void queryUserByUsername() {
		User user = userDao.queryUser("11");
		System.out.println(user.getPassword());
	}

	@Test
	public void changePassword() {
//		User user=new User("467942350@qq.com", "123456");
//		System.out.println(userDao.changePassword(user));
//		userDao.update("user", "password=8888", 43);
//		userDao.deletesById("user", "41");
//		User user=userDao.getOne("select * from user where id=44");
//		System.out.println(user);
	}
}
