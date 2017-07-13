/**
 * 
 */
package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import Entity.Goods;
import Entity.User;


public interface GoodsDao extends BaseDao<Goods> {
	@Select("SELECT * FROM goods")
	List<Goods> queryGoods();

	@Select("select * from goods where id=#{id}")
	Goods queryGoodById(@Param("id") int id);

	@Update("update goods set number=number-#{cutNumber} where id=#{id}")
	int cutNumber(@Param("id") int id, @Param("cutNumber") int cutNumber);

	@Select("select * from goods where id in(select good_id from collection where user_id=#{user.id})")
	List<Goods> queryByCollection(@Param("user") User user);

	@Insert("insert into collection(good_id,user_id) values (#{id},#{user.id})")
	@Options(useGeneratedKeys=false)
	int addNewCollection(@Param("id") int id, @Param("user") User user);
	
	
	@Select("select * from goods where name=#{name}")
	Goods queryGoodByName(@Param("name")String name);
	
	@Update("update goods set state=#{state} where id in (#{ids})")
	int toogleGoods(@Param("ids")String ids,@Param("state")int state);
	
	@Insert("insert into goods(name,number,presentprice,content,image,image2,state) values (#{name},#{number},#{presentprice},#{content},#{image},#{image2},0) ")
	@Options(useGeneratedKeys=false)
	int addGood(Goods good);
	
	@Update("update goods set name=#{name},number=#{number},presentprice=#{presentprice},content=#{content} where id=#{id}")
	int changeGood(Goods good);
}
