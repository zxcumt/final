/**
 * 
 */
package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import Entity.Order_Goods;
import Entity.Orders;
import Entity.User;


public interface OrderDao extends BaseDao<Orders>{
	/**
	 * 插入订单TODO
	 * int
	 */
	@Insert("INSERT INTO orders (user_id,ordernumber,starttime,address,personname,phone,totalprice,state) VALUES  (#{user.id},#{ordernumber},#{starttime},#{address},#{personname},#{phone},#{totalprice},#{state})")
	@Options( useGeneratedKeys=true, keyProperty="id")
	int addOrder(Orders order);
	/**
	 * 插入订单商品中间表Order_Goods
	 * TODO
	 * int
	 */
	@Insert("insert into orders_goods(order_id,good_id,number,sinplePrice,size) values (#{order.id},#{good.id},#{number},#{sinplePrice},#{size})")
	@Options(useGeneratedKeys=false)
	int addOrder_Goods(Order_Goods order_Good);
	
	/**
	 * 根据用户查询单个订单
	 * TODO
	 * List<Order_Goods>
	 */
	@Select("select orders_goods.* from orders_goods join orders  where  orders.id=orders_goods.order_id and orders.user_id=#{user.id}")
    @Results({	
		@Result(property="good",column="good_id",one=@One(select="Dao.GoodsDao.queryGoodById",fetchType=FetchType.EAGER)),
		@Result(property="order",column="order_id",one=@One(select="Dao.OrderDao.queryOrderById",fetchType=FetchType.LAZY))
	})
	List<Order_Goods> queryOrders_GoodsByUserWithGoods(@Param("user")User user);
	
	
	@Select("select * from orders where id=#{id}")
	Orders queryOrderById(@Param("id")int id);
	
	/**
	 * 根据用户查询多个订单
	 * TODO
	 * List<Order_Goods>
	 */
	@Select("select * from orders where user_id=#{user.id} order by id desc")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="id",property="order_goods",many=@Many(select="Dao.OrderDao.queryOrders_GoodsByOrderIdWithGoods",fetchType=FetchType.LAZY))
	})
	List<Orders> queryOrdersByUserWithGoods(@Param("user")User user);
	
	/**
	 * 根据订单Id查询中间表
	 * TODO
	 * List<Order_Goods>
	 */
	@Select("select * from orders_goods where order_id=#{orderId}")
    @Results({	
		@Result(property="good",column="good_id",one=@One(select="Dao.GoodsDao.queryGoodById",fetchType=FetchType.EAGER))
	})
	List<Order_Goods> queryOrders_GoodsByOrderIdWithGoods(@Param("orderId")int orderId);
	
	@Update("update orders set state=#{state} where id=#{id}")
	int changeState(@Param("id")int id,@Param("state")String state);
	
}
