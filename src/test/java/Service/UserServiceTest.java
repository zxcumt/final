/**
 * 
 */
package Service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-*.xml" })
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void test() {
		User user = new User("aaaaasdfg", "bbbb");
		System.out.println(userService.registUser(user));
	}
	@Test
	public void queryUser(){
		String username="11111";
		System.out.println(userService.queryUserByUsername(username));
	}

}
