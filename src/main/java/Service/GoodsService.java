package Service;

import java.util.List;
import java.util.Map;

import Dto.AddCartDto;
import Dto.QueryCarksAllDto;
import Entity.Goods;
import Entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public interface GoodsService {
	JSONArray queryGoodsByPage(int pageNo, int pageSize);

	JSONArray queryOneById(int id);

	boolean addToCart(AddCartDto addCartDto);

	QueryCarksAllDto queryShoppingCartByUser(String username);


	boolean deleteOneFromCart(int id);

	boolean emptyCart(String username);
   
	List<Goods> queryCollection(String username);
	
	boolean addCollection(int id,String username);
	
	Map<String, Object> queryGoodsByPageForBack(int pageNo, int pageSize,int state);
	
	Goods queryGoodsByName(String name);
	
	boolean toggleGoods(String ids,int yunsuan);
	
	boolean addGood(Goods good);
	
	boolean changeGood(Goods good);
}
