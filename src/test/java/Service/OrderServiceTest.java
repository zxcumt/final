package Service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.User;


	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration({ "classpath:spring/spring-*.xml" })
	public class OrderServiceTest {
		@Autowired
		private OrderService orderService;

		@Test
		public void test() {
			System.out.println(orderService.ordersuccess(15));
		}
		@Test
		public void queryAllOrdersByUsername() {
			User user = new User();
			user.setId(40);
		}
	}
