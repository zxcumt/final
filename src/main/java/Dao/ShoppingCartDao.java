package Dao;

import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import Entity.ShoppingCart;
import Entity.User;

public interface ShoppingCartDao extends BaseDao<ShoppingCart>{
	@Insert("insert into shoppingcart(user_id,good_id,number,size,tier) values (#{user.id},#{good.id},#{number},#{size},${tier})")
	@Options(useGeneratedKeys=false )
    int addShoppingCart(ShoppingCart shoppingCart);
	
	@Select("select * from shoppingcart where user_id=#{user_id} and good_id=#{good_id}")
	ShoppingCart queryOneForExist(@Param("user_id")int user_id,@Param("good_id")int good_id);
	
	@Update("update shoppingcart set number=#{number},tier=#{tier},size=#{size} where id=#{id}")
	int updateOne(ShoppingCart shoppingCart);
	
	@Select("select * from shoppingcart where user_id=#{user.id}")
	@Results({
		@Result(column="good_id",property="good",
	            one=@One(select="Dao.GoodsDao.queryGoodById",fetchType=FetchType.EAGER))
	})	
	List<ShoppingCart> queryListByUser(@Param("user")User user);
	
	@Delete("delete from shoppingcart where user_id=${user.id}")
	int deleteCartByUsername(@Param("user")User user);
	
	@Select("select * from shoppingcart where id in (${ids})")
	@Results({
		@Result(column="good_id",property="good",
	            one=@One(select="Dao.GoodsDao.queryGoodById",fetchType=FetchType.EAGER))
	})	
    List<ShoppingCart> queryCartsByIds( @Param("ids") String ids);	
	
}
