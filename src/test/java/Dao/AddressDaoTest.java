package Dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.Address;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class AddressDaoTest {
	@Autowired
	private AddressDao AddressDao;

	@Test
	public void test() {
		Address address=AddressDao.queryAddressByIdWithUser(11);
		System.out.println(address);
	}
	@Test
	public void fenye(){
		List<Address> address=AddressDao.findByPage("select * from address", 1, 100);
		System.out.println(address);
	}

}
