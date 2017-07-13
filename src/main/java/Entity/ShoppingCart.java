/**
 * 
 */
package Entity;

import Dto.AddCartDto;


public class ShoppingCart {
	private int id;
	private User user;
	private Goods good;
	private int number;
	private int size;
	private int tier;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGood() {
		return good;
	}

	public void setGood(Goods good) {
		this.good = good;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public double getSinplePrice() {
		return good.getPresentprice() * number * size;
	}

	public ShoppingCart(AddCartDto addCartDto) {
		super();
		this.number = addCartDto.getNumber();
		this.size = addCartDto.getSize();
		this.tier = addCartDto.getTier();
	}

	public ShoppingCart() {
		super();
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", user=" + user + ", good=" + good + ", number=" + number + ", size=" + size
				+ ", tier=" + tier + "]";
	}

}
