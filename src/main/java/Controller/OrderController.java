package Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Dto.QueryCarksAllDto;
import Entity.Address;
import Entity.Orders;
import Entity.ShoppingCart;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController<Orders> {
	/**
	 * 订单确认 TODO String
	 */
	@RequestMapping("/consureCart")
	public String consureCart(HttpSession session, Model model, @RequestParam("cartIds") String cartIds,
			@RequestParam("username") String username) {
		/*
		 * 获取选择要支付的购物车里面的商品
		 */
		List<ShoppingCart> shoppingCarts = orderservice.queryCartsByIds(cartIds);
		QueryCarksAllDto queryCarksAllDto = new QueryCarksAllDto(shoppingCarts);
		/*
		 * 该用户可供选择的地址
		 */
		List<Address> addresses = addressService.queryAddressByUser(username);
		model.addAttribute("cakes", queryCarksAllDto.getCakes());
		model.addAttribute("addresss", addresses);
		session.setAttribute("totalprice", queryCarksAllDto.getTotalprice());
		return "pay";
	}

	/**
	 * 添加订单 TODO boolean
	 */
	@RequestMapping("addOrder")
	@ResponseBody
	public int addOrder(@RequestParam("cartIds[]") String cartIds, @RequestParam("addressId") int addressId) {
		return orderservice.addOrder(cartIds, addressId);
	}

	@RequestMapping("/ordersuccess")
	public String ordersuccess(Model model, @RequestParam("orderId") int orderId) {
		Orders order = orderservice.ordersuccess(orderId);
		model.addAttribute("order", order);
		return "ordersuccess";
	}
	/*
	 * 以下为后台管理操作
	 */
	@RequestMapping(value="/queryAllOrderByBack")
	@ResponseBody
	public Map<String,Object> queryAllOrderByBack(@RequestParam("rows")int rows,@RequestParam("page")int page,@RequestParam(value="username",required=false)String username){		
		System.out.println(username);
		if(username!=null&&!username.equals("")){
			return orderservice.queryAllOrderByBackByUsername(username, page, rows);
		}else{
			return orderservice.queryAllOrderByBack(rows, page);
		}	
	}
	@RequestMapping("/queryOrderDetailByBack")
	@ResponseBody
	public Map<String,Object> queryOrderDetailByBack(@RequestParam("id")int id){
		maps.put("rows", orderservice.queryOrderDetailByBack(id));
		return maps;		
	}
	@RequestMapping("/orderState")
	@ResponseBody
	public boolean orderState(@RequestParam("orderid")int orderid,@RequestParam("state")int state){
		
		return orderservice.changeState(orderid, state);
	}
}
