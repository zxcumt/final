package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mchange.io.FileUtils;

import Dto.AddCartDto;
import Dto.QueryCarksAllDto;
import Entity.Goods;


@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController<Goods> {
	/**
	 * 首页商品信息 TODO String
	 */
	@RequestMapping("/goodsforindex")
	public String goodsforindex(Model model) {
		jsonArray = goodsService.queryGoodsByPage(1, 10);
		model.addAttribute("cakes", jsonArray);
		return "index";
	}

	/**
	 * 商品详情 TODO String
	 */
	@RequestMapping("/single")
	public String sinpleGood(Model model, @RequestParam("id") int id) {
		jsonArray = goodsService.queryOneById(id);
		model.addAttribute("cake", jsonArray.get(0));
		return "single";
	}

	/**
	 * 加入cake购物车 TODO boolean
	 */
	@RequestMapping("/addCart")
	@ResponseBody
	public boolean addToCart(HttpSession session, AddCartDto addCartDto) {
		double totalprice = (double) session.getAttribute("totalprice");
		session.setAttribute("totalprice", totalprice + addCartDto.getSinplePrice());
		return goodsService.addToCart(addCartDto);
	}

	/**
	 * 用户查看购物车 String
	 */
	@RequestMapping("/cartByUser")
	public String queryCartByUser(HttpSession session, Model model, @RequestParam("username") String username) {
		QueryCarksAllDto queryCarksAllDto = goodsService.queryShoppingCartByUser(username);
		model.addAttribute("cakes", queryCarksAllDto.getCakes());
		session.setAttribute("totalprice", queryCarksAllDto.getTotalprice());
		return "checkout";
	}

	/**
	 * 删除购物车里面的商品 boolean
	 */
	@RequestMapping("/deleteOneFromCart")
	@ResponseBody
	public boolean deleteOneFromCart(HttpSession session, @RequestParam("cartId") int cartId,
			@Param("cartprice") double cartprice) {
		double totalprice = (double) session.getAttribute("totalprice");
		session.setAttribute("totalprice", totalprice - cartprice);
		return goodsService.deleteOneFromCart(cartId);
	}

	/**
	 * 删除购物车里面的所有商品 boolean
	 */
	@RequestMapping("/emptyCart")
	@ResponseBody
	public boolean emptyCart(HttpSession session, @RequestParam("username") String username) {
		session.setAttribute("totalprice", 0.00);
		return goodsService.emptyCart(username);
	}

	@RequestMapping("/addCollection")
	@ResponseBody
	public boolean addCollection(@RequestParam("id") int id, @RequestParam("username") String username) {
		return goodsService.addCollection(id, username);
	}

	/*
	 * 以下为后台商品管理的请求能容，全是从backcontroller传来的请求
	 */
	@RequestMapping("/queryGoodsForBack")
	@ResponseBody
	public Map<String, Object> queryGoosForBack(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "name", required = false) String name) {
		if (name != null) {
			lists.add(goodsService.queryGoodsByName(name));
			maps.put("rows", lists);
			maps.put("total", 1);
			return maps;
		} else {
			return goodsService.queryGoodsByPageForBack(page, rows, 0);
		}

	}

	@RequestMapping("/downGoods")
	@ResponseBody
	public boolean downGoods(@Param("ids") String ids) {
		return goodsService.toggleGoods(ids, 1);
	}

	@RequestMapping("/queryDownGoodsForBack")
	@ResponseBody
	public Map<String, Object> queryDownGoodsForBack(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "name", required = false) String name) {
		if (name != null) {
			lists.add(goodsService.queryGoodsByName(name));
			maps.put("rows", lists);
			maps.put("total", 1);
			return maps;
		} else {
			return goodsService.queryGoodsByPageForBack(page, rows, 1);
		}
	}

	@RequestMapping("/upGoods")
	@ResponseBody
	public boolean upGoods(@Param("ids") String ids) {
		return goodsService.toggleGoods(ids, 0);
	}

	@RequestMapping(value = "/addGood", method = RequestMethod.POST)
	@ResponseBody
	public boolean addGood(HttpServletRequest request, @RequestParam("indeximage") MultipartFile indeximage,
			@RequestParam("detailimage") MultipartFile detailimage,Goods good) throws IllegalStateException, IOException {
		if (!indeximage.isEmpty() && !detailimage.isEmpty()) {
			String path = request.getServletContext().getRealPath("/images");
			String filename = UUID.randomUUID().toString();
			File file = new File(path, filename);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			String filename2 = UUID.randomUUID().toString();
			indeximage.transferTo(new File(path + File.separator + filename + ".jpg"));
			detailimage.transferTo(new File(path + File.separator + filename2 + ".jpg"));
			good.setImage("http://localhost:8080/MiaoSha/images/"+filename + ".jpg");
			good.setImage2("http://localhost:8080/MiaoSha/images/"+filename2 + ".jpg");
			
		}
		return 	goodsService.addGood(good);
	}
	
	@RequestMapping("/changeGood")
	@ResponseBody
	public boolean changeGood(Goods good){
		return goodsService.changeGood(good);
	}
}
