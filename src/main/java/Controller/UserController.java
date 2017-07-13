package Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Dto.QueryCarksAllDto;
import Dto.QueryOrderDto;
import Entity.Address;
import Entity.Goods;
import Entity.User;
import Util.EmailSendUtil;


@Controller
@RequestMapping("/user")
@SessionAttributes("username")
public class UserController extends BaseController<User> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private EmailSendUtil emailSendUtil = new EmailSendUtil();

	@ModelAttribute("user")
	public User usermodel(@RequestParam("username") String username,
			@RequestParam(value = "password", required = false) String password, Model model) {
		User user = new User(username, password);
		return user;
	}

	@RequestMapping("/register")
	@ResponseBody
	public boolean register(Model model, @ModelAttribute("user") User user) {
		if (userService.registUser(user)) {
			model.addAttribute("username", user.getUsername());
			emailSendUtil.sendEmail("467942350@qq.com", "注册成功", "注册成功");
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("/login")
	@ResponseBody
	public boolean login(HttpSession session, @ModelAttribute("user") User user, Model model) {
		if (userService.login(user)) {
			model.addAttribute("username", user.getUsername());
			session.setAttribute("totalprice", 0.00);
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping("/logincancel")
	@ResponseBody
	public boolean logincancel(Model model, @RequestParam("username") String username) {
		if (model.asMap().get("username").equals(username))
			model.addAttribute("username", "");
		return true;
	}

	@RequestMapping(value = "/isused", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean queryUser(Model model, String username) {
		return userService.queryUserByUsername(username);
	}

	/*
	 * 找回密码第一步
	 */
	@RequestMapping(value = "/findpassword", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean findPassword(HttpServletResponse response, String username) {
		boolean haveuser = userService.queryUserByUsername(username);
		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(5, 9);
		if (haveuser) {
			emailSendUtil.sendEmail(username, "找回密码", result);
			Cookie cookie = new Cookie("identify", result);
			Cookie cookie2 = new Cookie("username", username);
			cookie.setMaxAge(3 * 60 * 60);
			response.addCookie(cookie);
			response.addCookie(cookie2);
		} else
			System.out.println("用户不存在");

		return haveuser;

	}

	/**
	 * 找回密码第二步 boolean
	 */
	@RequestMapping(value = "/findpasswordnext", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean findpasswordnext(String username, @CookieValue("identify") String identify2, String identify) {
		return identify.equals(identify2);
	}

	/**
	 * 找回密码第三步
	 */
	@RequestMapping(value = "/findpasswordthree", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean findpasswordthree(Model model, @CookieValue("username") String username, String password) {
		User user = new User(username, password);
		boolean success = userService.changePassword(user);
		if (success)
			model.addAttribute("username", user.getUsername());
		return success;
	}

	@RequestMapping("/usermessage")
	public String usermessage(@RequestParam("username") String username) {

		return "usermessage";
	}

	@RequestMapping("/usermenu")
	public String usermessage(HttpSession session,Model model,@RequestParam("menu") String menu, String username) {

		switch (menu) {
	
		case "我的购物车":
			QueryCarksAllDto queryCarksAllDto = goodsService.queryShoppingCartByUser(username);
			model.addAttribute("cakes",  queryCarksAllDto.getCakes());
			session.setAttribute("totalprice", queryCarksAllDto.getTotalprice());
			return  "usermenu"+"/cart";
		case "我的订单": 
			List<QueryOrderDto> queryOrderDtos=orderservice.queryAllOrdersByUsername(username);			
			model.addAttribute("orders", queryOrderDtos);
			return "usermenu"+"/orders";
		case "我的收藏":
            List<Goods> goods=goodsService.queryCollection(username);
            model.addAttribute("goods", goods);
            System.out.println(goods);
			return "usermenu/collection";
		case "我的地址":
            List<Address> addresses= addressService.queryAddressByUser(username);
            model.addAttribute("addresses", addresses);
			return "usermenu"+"/address";
		case "我的信息":
			
			return "usermenu"+"/userimformation";
		default:
			return "usermessage";
		}

	}
}
