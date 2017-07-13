package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JspController {
	/**
	 * 默认页面 TODO String
	 */
	
	@RequestMapping("")
	public String index() {
		return "forward:/goods/goodsforindex";
	}

	/**
	 * 实现jsp的普通跳转
	 * 
	 * @param jspname
	 * @return
	 */
	@RequestMapping("/{jspname}")
	public String jspname(@PathVariable String jspname) {
		switch (jspname) {
		case "index":
			return "forward:/goods/goodsforindex";
		case "single":
			return "forward:/goods/single";
		case "checkout":
			return "forward:/goods/cartByUser";
		case "pay":
			return "forward:/order/consureCart";
		case "ordersuccess":
			return "forward:/order/ordersuccess";
		case "userdetail":
			return "forward:/user/usermessage";
		case "back":
			return "redirect:/back/backmain";
	
		default:
			return jspname;
		}
	}

}
