package Dto;

/**
 * 用于封装添加地址行为的数据
 */
public class AddAddressDto {
	private String province;
	private String city;
	private String personname;
	private String phone;
	private String county;
	private String addressdetail;
	private boolean isdefault;
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
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public boolean isIsdefault() {
		return isdefault;
	}
	public void setIsdefault(boolean isdefault) {
		this.isdefault = isdefault;
	}
	
	public AddAddressDto(String province, String city, String personname, String phone, String county,
			String addressdetail, boolean isdefault) {
		super();
		this.province = province;
		this.city = city;
		this.personname = personname;
		this.phone = phone;
		this.county = county;
		this.addressdetail = addressdetail;
		this.isdefault = isdefault;
	}
	public AddAddressDto() {
		super();
	}
	
}
