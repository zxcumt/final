/**
 * 
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/back")
public class BackController {
 
	
	private final String URL = "back/";

	@RequestMapping("/Order_{jspname}")
	public String orderjspname(@PathVariable String jspname){
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn");
		return "forward:/order/"+jspname;
	}
	
	@RequestMapping("/{jspname}")
	public String jspname(@PathVariable String jspname) {
		switch (jspname) {
		case "Goods_queryGoodsForBack":			
			return "forward:/goods/queryGoodsForBack";
		case "Goods_downGoods":
			return "forward:/goods/downGoods";			
		case "Goods_queryDownGoodsForBack":
			return "forward:/goods/queryDownGoodsForBack";
		case "Goods_upGoods":
			return "forward:/goods/upGoods";
		case "Goods_addGood":
			return "forward:/goods/addGood";
		case "Goods_changeGood":
			return "forward:/goods/changeGood";
	
		default:
			return URL + jspname;
		}								
	}
}
