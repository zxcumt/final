package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import Entity.Address;
import Entity.Area;
import Entity.User;


public interface AddressDao extends BaseDao<Address> {
	@Select("select * from address  where  user_id=#{user.id}")
	@Results(@Result(property = "addressdetail", column = "detail"))

	List<Address> queryAddressByUser(@Param("user") User user);

	@Select("select code,name from province")
	List<Area> queryProvince();

	@Select("select code,name from city where provincecode=#{code}")
	List<Area> queryCity(@Param("code") String code);

	@Select("select code,name from area where citycode=#{code}")
	List<Area> queryCounty(@Param("code") String code);

	@Insert("insert  into address(province,city,personname,phone,county,detail,isdefault,user_id) values (#{province},#{city},#{personname},#{phone},#{county},#{addressdetail},#{isdefault},#{user.id})")
	@Options(useGeneratedKeys = false)
	int addAddress(Address address);

	@Select("select * from address  where  id=#{id}")
	@Results({ @Result(property = "addressdetail", column = "detail"),
			@Result(property = "user", column = "user_id", one = @One(select = "Dao.UserDao.queryById", fetchType = FetchType.LAZY) ) 
	})
	Address queryAddressByIdWithUser(@Param("id") int id);
	
	@Update("update address set isdefault=0 where id=#{id}")
	int changeDefaultAddress(@Param("id")int id);
	
	@Select("update address set isdefault=1 where isdefault=0 and user_id=#{user.id}")
	void cancelDefaultAddress(@Param("user")User user);
	
	@Delete("delete from address where id=#{id}")
	int deleteAddress(@Param("id")int id);
}
