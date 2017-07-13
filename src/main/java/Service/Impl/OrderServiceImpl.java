package Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dto.QueryCarksAllDto;
import Dto.QueryCartCakeDto;
import Dto.QueryOrderDto;
import Entity.Address;
import Entity.Order_Goods;
import Entity.Orders;
import Entity.ShoppingCart;
import Entity.User;
import Service.OrderService;


@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	/*
	 * TODO
	 * 
	 */
	@Override
	public List<ShoppingCart> queryCartsByIds(String ids) {
		// TODO Auto-generated method stub
		List<ShoppingCart> carts = shoppingCartDao.queryCartsByIds(ids);
		return carts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 生成订单（添加orders和orders_goods并且删除cart中的数据) 返回 订单主键
	 * 
	 * @see Service.OrderService#addOrder(java.lang.String, int)
	 */
	@Override
	@Transactional
	public int addOrder(String cartIds, int addressId) {
		// TODO Auto-generated method stub
		try {
			List<ShoppingCart> shoppingCarts = shoppingCartDao.queryCartsByIds(cartIds);
			QueryCarksAllDto allDto = new QueryCarksAllDto(shoppingCarts);
			Address address = addressDao.queryAddressByIdWithUser(addressId);
			Date date = new Date();
			/*
			 * 添加订单
			 */
			Orders order = new Orders(date, address, allDto.getTotalprice());
			orderDao.addOrder(order);
			/*
			 * 添加订单详情
			 */
			for (int i = 0; i < shoppingCarts.size(); i++) {
				Order_Goods order_Goods = new Order_Goods(order, shoppingCarts.get(i));
				orderDao.addOrder_Goods(order_Goods);
				/*
				 * 减库存
				 */
				goodsDao.cutNumber(shoppingCarts.get(i).getGood().getId(), shoppingCarts.get(i).getNumber());
			}
			/*
			 * 清空购物车
			 */
			shoppingCartDao.deletesById(CartTABLE, cartIds);
			return order.getId();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	/*
	 * TODO
	 * 
	 */
	@Override
	public Orders ordersuccess(int orderId) {
		// TODO Auto-generated method stub
		Orders order = orderDao.queryById(OrdersTable, orderId);
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.OrderService#queryAllOrdersByUsername(java.lang.String)
	 */
	@Override
	public List<QueryOrderDto> queryAllOrdersByUsername(String username) {
		// TODO Auto-generated method stub
		User user = userDao.queryUser(username);
		List<Orders> orderss = orderDao.queryOrdersByUserWithGoods(user);
		List<QueryOrderDto> queryOrderDtos = new LinkedList<QueryOrderDto>();
		int size = orderss.size();
		for (int i = 0; i < size; i++) {

			Orders order = orderss.get(i);
			System.out.println(order.getId());
			QueryOrderDto queryOrderDto = new QueryOrderDto(order);
			queryOrderDtos.add(queryOrderDto);
		}
		return queryOrderDtos;
	}

	/*
	 * TODO
	 * 
	 */
	@Override
	public Map<String,Object> queryAllOrderByBack(int rows ,int page) {
		// TODO Auto-generated method stub
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("rows", orderDao.findByPage("select * from orders", page, rows));
		maps.put("total", orderDao.findCountBySql("from orders"));
		return maps;
	}

	/* TODO
	 * 
	 */
	@Override
	public List<QueryCartCakeDto> queryOrderDetailByBack(int orderid) {
		// TODO Auto-generated method stub
		ArrayList<Order_Goods> order_Goods=(ArrayList<Order_Goods>) orderDao.queryOrders_GoodsByOrderIdWithGoods(orderid);
		QueryCarksAllDto carksAllDto=new QueryCarksAllDto(order_Goods);		
		return carksAllDto.getCakes();
	}

	/* TODO
	 * 
	 */
	@Override
	public boolean changeState(int orderid, int state) {
		// TODO Auto-generated method stub
		String newState=null;
		switch (state) {
		case 1:
			newState="待发货";
			break;
		case 2:	
			newState="已发货";
			break;
		case 3:	
			newState="订单完成";
			break;  
		default:
			
			break;
		}
		
		return orderDao.changeState(orderid, newState)>0?true:false;
	}

	/* TODO
	 * 
	 */
	@Override
	public Map<String, Object> queryAllOrderByBackByUsername(String username,int page ,int rows) {
		// TODO Auto-generated method stub
		Map<String,Object> maps=new HashMap<String,Object>();
		String sql="select * from orders where user_id =(select id from user where username='"+username+"')";
		maps.put("rows", orderDao.findByPage(sql, page, rows));
		maps.put("total", orderDao.findCountBySql(" from orders where user_id =(select id from user where username='"+username+"')"));
		return maps;
	}

}
