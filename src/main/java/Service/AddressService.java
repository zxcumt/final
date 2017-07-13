package Service;

import java.util.List;

import Dto.AddAddressDto;
import Entity.Address;
import Entity.Area;


public interface AddressService {
	  List<Address> queryAddressByUser(String username);
	  List<Area>  queryProvince(); 
	  List<Area> queryAreaChild(String code,String area);
	  boolean addAddress(AddAddressDto addAddressDto,String username);
	  boolean changeDefaultAddress(int id,String username);
	  boolean deleteAddress(int id);
}
