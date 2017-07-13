package Entity;

import Dto.AddAddressDto;


public class Address {
	
	private int id;
	private String province;
	private String city;
	private String personname;
	private String phone;
	private String county;
	private String addressdetail;
	private int isdefault;

	private User user;

	public int getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
   
	public String getCompleteAddress(){
		return province+city+county+addressdetail;
	}
	public User getUser() {
		return user;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getAddressdetail() {
		return addressdetail;
	}

	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}

	public Address(String province, String city, String personname, String phone, String addressdetail, User user) {
		super();
		this.province = province;
		this.city = city;
		this.personname = personname;
		this.phone = phone;
		this.addressdetail = addressdetail;
		this.user = user;
	}

	public Address() {
		super();
	}

	public Address(AddAddressDto addAddressDto, User user) {
		super();
		this.province = addAddressDto.getProvince();
		this.city = addAddressDto.getCity();
		this.personname = addAddressDto.getPersonname();
		this.phone = addAddressDto.getPhone();
		this.county = addAddressDto.getCounty();
		this.addressdetail = addAddressDto.getAddressdetail();
		this.isdefault =addAddressDto.isIsdefault()?0:1;//默认地址为0,否则为1
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city=" + city + ", personname=" + personname
				+ ", phone=" + phone + ", county=" + county + ", addressdetail=" + addressdetail + ", isdefault="
				+ isdefault + ", user=" + user + "]";
	}


	
}
