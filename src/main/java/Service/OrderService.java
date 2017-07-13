package Service;

import java.util.List;
import java.util.Map;

import Dto.QueryCartCakeDto;
import Dto.QueryOrderDto;
import Entity.Orders;
import Entity.ShoppingCart;


public interface OrderService {
	List<ShoppingCart> queryCartsByIds(String cartids);

	int addOrder(String cartIds, int addressId);

	Orders ordersuccess(int orderId);

	List<QueryOrderDto> queryAllOrdersByUsername(String username);
	
	Map<String, Object> queryAllOrderByBack(int rows ,int page);
	
	List<QueryCartCakeDto> queryOrderDetailByBack(int orderid);
	
	boolean changeState(int orderid,int state);
	
	Map<String, Object> queryAllOrderByBackByUsername(String username, int page, int rows);
}
