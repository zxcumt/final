/**
 * 
 */
package Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Order_Goods;
import Entity.Orders;


public class QueryOrderDto {
	private int id;
	private Date starttime;
	private String address;
	private String personname;
	private String phone;
	private String ordernumber;
	private String state;
	private QueryCarksAllDto queryCarksAllDto;
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
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


	public String getOrdernumber() {
		return ordernumber;
	}


	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public QueryCarksAllDto getQueryCarksAllDto() {
		return queryCarksAllDto;
	}

	public void setQueryCarksAllDto(QueryCarksAllDto queryCarksAllDto) {
		this.queryCarksAllDto = queryCarksAllDto;
	}

	public QueryOrderDto(Orders order) {
		super();
		QueryCarksAllDto queryCarksAllDto=new QueryCarksAllDto((ArrayList<Order_Goods>)order.getOrder_goods(),order.getState());
		queryCarksAllDto.setTotalprice(order.getTotalprice());
		this.id = order.getId();
		this.queryCarksAllDto = queryCarksAllDto;
		this.starttime = order.getStarttime();
		this.address = order.getAddress();
		this.personname = order.getPersonname();
		this.phone = order.getPhone();
		this.ordernumber = order.getOrdernumber();
		this.state=order.getState();
	}

	public QueryOrderDto() {
		super();
	}


	public QueryOrderDto(Date starttime, String address, String personname, String phone, String ordernumber,
			QueryCarksAllDto queryCarksAllDto) {
		super();
		this.starttime = starttime;
		this.address = address;
		this.personname = personname;
		this.phone = phone;
		this.ordernumber = ordernumber;
		this.queryCarksAllDto = queryCarksAllDto;
	}


	@Override
	public String toString() {
		return "QueryOrderDto [id=" + id + ", starttime=" + starttime + ", address=" + address + ", personname="
				+ personname + ", phone=" + phone + ", ordernumber=" + ordernumber + ", queryCarksAllDto="
				+ queryCarksAllDto + "]";
	}



	
	
}
