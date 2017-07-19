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
public class AddressServiceTest {
	@Autowired
	private AddressService addressService;

	@Test
	public void test() {
		System.out.println(addressService.deleteAddress(3));
	}
	@Test
	public void queryAddressByUser() {
		User user = new User();
		user.setId(40);
	}

}
