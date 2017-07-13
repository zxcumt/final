/**
 * 
 */
package Entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;


public class Orders {
	private int id;
	private User user;
	private Date starttime;
	private String address;
	private String personname;
	private String phone;
	private double totalprice;
	private String state;
	private String ordernumber;
	private List<Order_Goods> order_goods;

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public int getId() {
		return id;
	}

	public String getPersonname() {
		return personname;
	}

	public void setPersonname(String personname) {
		this.personname = personname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Orders() {
		super();
	}

	public List<Order_Goods> getOrder_goods() {
		return order_goods;
	}

	public void setOrder_goods(List<Order_Goods> order_goods) {
		this.order_goods = order_goods;
	}

	public Orders(Date starttime, Address address, double totalprice) {
		super();
		this.user = address.getUser();
		this.starttime = starttime;
		this.address = address.getCompleteAddress();
		this.totalprice = totalprice;
		this.state = "已支付";
		this.personname = address.getPersonname();
		this.phone = address.getPhone();
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		this.ordernumber = String.format("%010d", hashCodeV);
	}

	public Orders(User user, Date starttime, String address, String personname, String phone, double totalprice,
			String state) {
		super();
		this.user = user;
		this.starttime = starttime;
		this.address = address;
		this.personname = personname;
		this.phone = phone;
		this.totalprice = totalprice;
		this.state = state;
	}

}
