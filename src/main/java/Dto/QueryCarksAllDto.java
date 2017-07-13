/**
 * 
 */
package Dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Entity.Goods;
import Entity.Order_Goods;
import Entity.Orders;
import Entity.ShoppingCart;


public class QueryCarksAllDto {
	private double totalprice;
	private List<QueryCartCakeDto> cakes;

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public List<QueryCartCakeDto> getCakes() {
		return cakes;
	}

	public void setCakes(List<QueryCartCakeDto> cakes) {
		this.cakes = cakes;
	}

	public QueryCarksAllDto() {
		super();
	}

	// public QueryCarksAllDto(List<QueryCartCakeDto> cakes) {
	// super();
	// double totalprice=0.00;
	// for (int i = 0; i < cakes.size(); i++) {
	// QueryCartCakeDto cartCakeDto=cakes.get(i);
	// Double
	// sinplePrices=cartCakeDto.getNumber()*cartCakeDto.getPrice()*cartCakeDto.getSize();
	// totalprice+=sinplePrices;
	// }
	// this.totalprice = totalprice;
	// this.cakes = cakes;
	// }
	/**
	 * 用于查看购物车
	 * 
	 * @param carts
	 */
	public QueryCarksAllDto(List<ShoppingCart> carts) {
		super();
		List<QueryCartCakeDto> cakes = new LinkedList<QueryCartCakeDto>();
		for (int i = 0; i < carts.size(); i++) {
			ShoppingCart cart = carts.get(i);
			Goods goods = cart.getGood();
			QueryCartCakeDto cartCakeDto = new QueryCartCakeDto(cart, goods);
			if (goods.getNumber() > cart.getNumber()) {
				cartCakeDto.setStatus("有货");
			} else {
				cartCakeDto.setStatus("库存只有" + goods.getNumber());
			}
			cakes.add(cartCakeDto);
			Double sinplePrices = cartCakeDto.getNumber() * cartCakeDto.getPrice() * cartCakeDto.getSize();
			this.totalprice += sinplePrices;
		}
		this.cakes = cakes;
	}

	/**
	 * 用于查看订单
	 */

	public QueryCarksAllDto(ArrayList<Order_Goods> order_Goods, String status) {
		super();
		List<QueryCartCakeDto> cakes = new LinkedList<QueryCartCakeDto>();
		for (int i = 0; i < order_Goods.size(); i++) {
			Order_Goods order_Good = order_Goods.get(i);
			QueryCartCakeDto cartCakeDto = new QueryCartCakeDto(order_Good);
			cartCakeDto.setStatus(status);
			cakes.add(cartCakeDto);
		}
		this.cakes = cakes;
	}

	public QueryCarksAllDto(ArrayList<Order_Goods> order_Goods) {
		super();
		List<QueryCartCakeDto> cakes = new LinkedList<QueryCartCakeDto>();
		for (int i = 0; i < order_Goods.size(); i++) {
			Order_Goods order_Good = order_Goods.get(i);
			QueryCartCakeDto cartCakeDto = new QueryCartCakeDto(order_Good);
			cakes.add(cartCakeDto);
		}
		this.cakes = cakes;
	}

	@Override
	public String toString() {
		return "QueryCarksAllDto [totalprice=" + totalprice + ", cakes=" + cakes + "]";
	}

}
