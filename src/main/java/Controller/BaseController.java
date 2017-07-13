package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import Service.AddressService;
import Service.GoodsService;
import Service.OrderService;
import Service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class BaseController<T> {
	@Autowired
	protected AddressService addressService;
	@Autowired
	protected OrderService orderservice;
	@Autowired
	protected UserService userService;
	@Autowired
	protected GoodsService goodsService;
	protected JSONArray jsonArray;
	protected JSONObject jsonObject;
	protected Map<String, Object> maps=new HashMap<String, Object>();
	protected List<T> lists=new ArrayList<T>();

}
