package Service.Impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.GoodsDao;
import Dao.ShoppingCartDao;
import Dao.UserDao;
import Dto.AddCartDto;
import Dto.QueryCarksAllDto;
import Entity.Goods;
import Entity.ShoppingCart;
import Entity.User;
import Service.GoodsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Service
public class GoodsServiceImpl extends BaseServiceImpl implements GoodsService {
	/*
	 * TODO 返回首页的cakes数据 包含（idame,image）
	 *
	 */
	@Override
	@Transactional(readOnly = true)
	public JSONArray queryGoodsByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		JSONArray jsonArray = new JSONArray();
		List<Goods> goods = goodsDao.findByPage("select * from goods where state = 0", pageNo, pageSize);
		/**
		 * 因为分页查询的goods数量较少，所以这样的遍历最快
		 * 
		 **/
		int size = goods.size();
		for (int i = 0; i < size; i++) {
			Goods good = goods.get(i);
			JSONObject jo = new JSONObject();
			jo.put("id", good.getId());
			jo.put("image", good.getImage());
			jo.put("name", good.getName());
			jo.put("presentprice", good.getPresentprice());
			jsonArray.add(jo);
		}
		return jsonArray;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.GoodsService#queryOneById(int)
	 */
	@Override
	@Transactional(readOnly = true)
	public JSONArray queryOneById(int id) {
		// TODO Auto-generated method stub
		Goods good = goodsDao.queryGoodById(id);
		JSONArray ja = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("id", good.getId());
		jo.put("name", good.getName());
		jo.put("price", good.getPresentprice());
		jo.put("content", good.getContent());
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(good.getImage());
		jsonArray.add(good.getImage2());
		jo.put("image", jsonArray);
		ja.add(jo);
		return ja;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.GoodsService#addToCart(int, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean addToCart(AddCartDto addCartDto) {
		// TODO Auto-generated method stub
		User user = userDao.queryUser(addCartDto.getUsername());
		Goods good = goodsDao.queryById(GoodsTABLE, addCartDto.getGood_id());
		ShoppingCart exist = shoppingCartDao.queryOneForExist((int) user.getId(), good.getId());
		int result = 0;
		if (exist != null) {
			exist.setNumber(exist.getNumber() + addCartDto.getNumber());
			exist.setTier(addCartDto.getTier());
			exist.setSize(addCartDto.getSize());
			result = shoppingCartDao.updateOne(exist);
		} else {
			ShoppingCart shoppingCart = new ShoppingCart(addCartDto);
			shoppingCart.setUser(user);
			shoppingCart.setGood(good);
			result = shoppingCartDao.addShoppingCart(shoppingCart);
		}
		return result > 0 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.GoodsService#queryShoppingCartByUser(Entity.User)
	 */
	@Override
	@Transactional(readOnly = true)
	public QueryCarksAllDto queryShoppingCartByUser(String username) {

		// TODO Auto-generated method stub
		// JSONObject jo=new JSONObject();
		// JSONArray jsonArray = new JSONArray();
		// User user = userDao.queryUser(username);
		// List<ShoppingCart> shoppingCarts =
		// shoppingCartDao.queryListByUser(user);
		// int size = shoppingCarts.size();
		// double totalprice=0.00;
		// for (int i = 0; i < size; i++) {
		// ShoppingCart shoppingCart = shoppingCarts.get(i);
		// JSONObject jsonObject = new JSONObject();
		// jsonObject.put("id", shoppingCart.getId());
		// jsonObject.put("name", shoppingCart.getGood().getName());
		// jsonObject.put("image", shoppingCart.getGood().getImage());
		// jsonObject.put("number", shoppingCart.getNumber());
		// if (shoppingCart.getGood().getNumber() > shoppingCart.getNumber()) {
		// jsonObject.put("status", "有货");
		// } else {
		// jsonObject.put("status", "库存只有" +
		// shoppingCart.getGood().getNumber());
		// }
		// jsonObject.put("price", shoppingCart.getGood().getPresentprice());
		// jsonObject.put("size", shoppingCart.getSize());
		// totalprice+=shoppingCart.getGood().getPresentprice()*shoppingCart.getSize()*shoppingCart.getNumber();
		// jsonArray.add(jsonObject);
		// }
		// jo.put("cakes", jsonArray);
		// jo.put("totalprice", totalprice);
		User user = userDao.queryUser(username);
		List<ShoppingCart> shoppingCarts = shoppingCartDao.queryListByUser(user);
		int size = shoppingCarts.size();
		QueryCarksAllDto queryCarksAllDto = new QueryCarksAllDto(shoppingCarts);
		return queryCarksAllDto;
	}

	@Override
	@Transactional()
	public boolean deleteOneFromCart(int cartid) {
		int result = shoppingCartDao.delete(CartTABLE, cartid);
		return result > 0 ? true : false;
	}

	@Override
	@Transactional()
	public boolean emptyCart(String username) {
		User user = userDao.queryUser(username);
		int result = shoppingCartDao.deleteCartByUsername(user);
		return result > 0 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.GoodsService#queryCollection(java.lang.String)
	 */
	@Override
	public List<Goods> queryCollection(String username) {
		// TODO Auto-generated method stub
		User user = userDao.queryUser(username);
		List<Goods> goods = goodsDao.queryByCollection(user);
		return goods;
	}

	/*
	 * TODO
	 * 
	 */
	@Override
	@Transactional
	public boolean addCollection(int id, String username) {
		// TODO Auto-generated method stub
		User user = userDao.queryUser(username);
		int result = goodsDao.addNewCollection(id, user);
		return result > 0 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Service.GoodsService#queryGoodsByPageForBack()
	 */
	@Override
	public Map<String, Object> queryGoodsByPageForBack(int pageNo, int pageSize, int state) {
		// TODO Auto-generated method stub
		List<Goods> goods = goodsDao.findByPage("select * from goods where goods.state = " + state, pageNo, pageSize);
		long total = goodsDao.findCountBySql("from goods where goods.state = 0");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", goods);
		map.put("total", total);
		return map;
	}

	/*
	 * TODO 根据名称查询商品
	 */
	@Override
	public Goods queryGoodsByName(String name) {
		// TODO Auto-generated method stub
		Goods good = goodsDao.queryGoodByName(name);
		return good;
	}

	/*
	 * TODO 下架商品
	 */
	@Override
	@Transactional
	public boolean toggleGoods(String ids, int state) {
		// TODO Auto-generated method stub
		return goodsDao.toogleGoods(ids, state) > 0 ? true : false;
	}

	/*
	 * TODO
	 * 添加一个商品
	 */
	@Override
	public boolean addGood(Goods good) {
		// TODO Auto-generated method stub
		return goodsDao.addGood(good) > 0 ? true : false;
	}

	/* TODO
	 * 
	 */
	@Override
	public boolean changeGood(Goods good) {
		// TODO Auto-generated method stub
		return goodsDao.changeGood(good)>0?true:false;
	}

}
