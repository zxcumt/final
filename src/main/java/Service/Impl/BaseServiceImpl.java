package Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import Dao.AddressDao;
import Dao.GoodsDao;
import Dao.OrderDao;
import Dao.ShoppingCartDao;
import Dao.UserDao;


public class BaseServiceImpl {
	@Autowired
	protected GoodsDao goodsDao;
	@Autowired
	protected UserDao userDao;
	@Autowired
	protected ShoppingCartDao shoppingCartDao;
	@Autowired
	protected AddressDao addressDao;
	@Autowired
	protected OrderDao orderDao;
	
	protected final String GoodsTABLE="goods";
	
	protected final String CartTABLE="shoppingcart";
	
	protected final String OrdersTable="orders";
}
