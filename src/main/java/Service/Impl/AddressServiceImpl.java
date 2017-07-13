package Service.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dto.AddAddressDto;
import Entity.Address;
import Entity.Area;
import Entity.User;
import Service.AddressService;


@Service
public class AddressServiceImpl  extends BaseServiceImpl implements AddressService{
	/* TODO
	 * 
	 */
	@Override
	public List<Address> queryAddressByUser(String username) {
		// TODO Auto-generated method stub
		User user=userDao.queryUser(username);
		List<Address> addresses=addressDao.queryAddressByUser(user);
		return addresses;
	}

	/* TODO
	 * 
	 */
	@Override
	public List<Area> queryProvince() {
		// TODO Auto-generated method stub
		
		return addressDao.queryProvince();
	}

	/* TODO
	 * 
	 */
	@Override
	public List<Area> queryAreaChild(String code, String area) {
		// TODO Auto-generated method stub
		List<Area> areas=new LinkedList<Area>();
		switch (area) {
		case "city":
			areas=addressDao.queryCity(code);
			break;
		case "county":
			areas=addressDao.queryCounty(code);
			break;
		default:
			break;
		}
		return areas;
	}

	/* TODO
	 * 
	 */
	@Override
	@Transactional
	public boolean addAddress(AddAddressDto addAddressDto, String username) {
		// TODO Auto-generated method stub
		User user=userDao.queryUser(username);
		if(addAddressDto.isIsdefault()){
			addressDao.cancelDefaultAddress(user);
		}
		Address address= new Address(addAddressDto, user);

		int result=addressDao.addAddress(address);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see Service.AddressService#changeDefaultAddress(int, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean changeDefaultAddress(int id, String username) {
		// TODO Auto-generated method stub
		User user=userDao.queryUser(username);
		addressDao.cancelDefaultAddress(user);
		int result=addressDao.changeDefaultAddress(id);
		System.out.println( result>0?true:false);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see Service.AddressService#deleteAddress()
	 */
	@Override
	public boolean deleteAddress(int id) {
		// TODO Auto-generated method stub
		int result=addressDao.deleteAddress(id);
		return result>0?true:false;
	}
}
