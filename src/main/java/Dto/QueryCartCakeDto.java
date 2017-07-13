/**
 * 
 */
package Dto;

import Entity.Goods;
import Entity.Order_Goods;
import Entity.ShoppingCart;

/**
 * 用于封装购物车里面的单个商品数据
 */
public class QueryCartCakeDto {
	private int id;
	private String name;
	private String image;
	private int number;// 购买数量
	private String status;
	private double price;
	private int size;
	private int tier;

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 用于查看购物车
	 * 
	 * @param cart
	 * @param goods
	 */
	public QueryCartCakeDto(ShoppingCart cart, Goods goods) {
		super();
		this.id = cart.getId();
		this.name = goods.getName();
		this.image = goods.getImage();
		this.number = cart.getNumber();
		this.price = goods.getPresentprice();
		this.size = cart.getSize();
	}

	public QueryCartCakeDto() {
		super();
	}

	/**
	 * 用于查看订单
	 */

	public QueryCartCakeDto(Order_Goods order_Goods) {
		super();
		this.id = order_Goods.getId();
		this.name = order_Goods.getGood().getName();
		this.image = order_Goods.getGood().getImage();
		this.number = order_Goods.getNumber();
		this.price = order_Goods.getGood().getPresentprice();
		this.size = order_Goods.getSize();
		this.tier=order_Goods.getTier();
	}

}
