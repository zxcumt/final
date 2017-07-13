/**
 * 
 */
package Dto;

/**
 * 封装添加购物车时候的单个数据
 */
public class AddCartDto {
	private String username;
	private int good_id;
	private double price;
	private int number;
	private int size;
	private int tier;// 蛋糕层数

	public double getSinplePrice() {
		return number * price * size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getGood_id() {
		return good_id;
	}

	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}

	public AddCartDto() {
		super();
	}

	public AddCartDto(String username, int good_id, int number, int size, int tier) {
		super();
		this.username = username;
		this.good_id = good_id;
		this.number = number;
		this.size = size;
		this.tier = tier;
	}

	@Override
	public String toString() {
		return "CartDto [username=" + username + ", good_id=" + good_id + ", number=" + number + ", size=" + size
				+ ", tier=" + tier + "]";
	}

}
