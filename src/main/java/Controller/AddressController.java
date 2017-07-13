package Controller;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Dto.AddAddressDto;
import Entity.Address;
import Entity.Area;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController<Address> {
	/**
	 * 根据用户查收获地址 TODO List<Address>
	 */
	@RequestMapping("/queryUserAddress")
	@ResponseBody
	public List<Address> queryAddressByUser(@RequestParam("username") String username) {
		List<Address> addresses = addressService.queryAddressByUser(username);

		return addresses;
	}

	/**
	 * 联动省市县 TODO List<Area>
	 */
	@RequestMapping("/queryArea")
	@ResponseBody
	public List<Area> queryArea(@RequestParam("area") String area,
			@RequestParam(value = "code", required = false) String code) {
		List<Area> areas = new LinkedList<Area>();
		switch (area) {
		case "province":
			areas = addressService.queryProvince();
			break;
		case "city":
			areas = addressService.queryAreaChild(code, area);
			break;
		case "county":
			areas = addressService.queryAreaChild(code, area);
			break;
		default:
			break;
		}
		return areas;
	}

	/**
	 * 添加地址 TODO boolean
	 */
	@RequestMapping("/addAddress")
	@ResponseBody
	public boolean addAddress(AddAddressDto addAddressDto, @RequestParam("username") String username) {
		return addressService.addAddress(addAddressDto, username);
	}

	/**
	 * 更改默认地址
	 */
	@RequestMapping("/changeAddress")
	@ResponseBody
	public boolean changeDefaultAddress(@RequestParam("id") int id, @RequestParam("username") String username) {
		boolean result = addressService.changeDefaultAddress(id, username);
		return result;
	}

	/**
	 * 删除地址
	 * 
	 */
	@RequestMapping("/deleteAddress")
	@ResponseBody
	public boolean deleteAddress(@RequestParam("id") int id) {
		return addressService.deleteAddress(id);
	}
}
