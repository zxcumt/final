/**
 * 
 */
package Dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.Goods;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class GoodsDaoTest {
	@Autowired
	private GoodsDao goodsDao;

	@Test
	public void test() {
		Goods good=goodsDao.queryGoodById(8);
		System.out.println(good);
	}
	@Test
	public void fenye(){
		List<Goods> goods=goodsDao.findByPage("select * from goods", 1, 10);
		System.out.println(goods);
	}

}
