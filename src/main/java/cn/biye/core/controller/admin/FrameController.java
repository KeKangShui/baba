package cn.biye.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模块身体加载
 *
 * @author ASUS 2017年9月22日
 */
@Controller
@RequestMapping(value = "/control")
public class FrameController {

	// 商品的身体
	@RequestMapping(value = "/frame/product_main.do")
	public String productMain() {
		return "frame/product_main";

	}
	// 商品的左
	@RequestMapping(value = "/frame/product_left.do")
	public String productLeft() {

		return "frame/product_left";
	}
	// 订单的身体
	@RequestMapping(value = "/frame/order_main.do")
	public String orderMain() {

		return "frame/order_main";
	}
	// 订单的左
	@RequestMapping(value = "/frame/order_left.do")
	public String orderLeft() {

		return "frame/order_left";
	}
}
