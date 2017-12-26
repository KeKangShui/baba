package cn.biye.core.controller.admin;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/control")
public class CenterController {

	// @RequestMapping(value = "/asd.do")
	// public String asd() {
	// System.out.println("1232");
	// return "index";
	// }

	// 每一个springmvc
	@RequestMapping(value = "/test/springmvc.do")
	public String test(String name, Date birthday) {

		System.out.println();
		return "";
	}

	/*
	 * @InitBinder // WebDataBinder为绑定页面传过来的数据 public void
	 * initBinder(WebDataBinder binder, WebRequest request) {
	 *
	 * DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 *
	 * // registerCustomEditor 为注册自定义编辑器 ，第二个参数为自定义Date的编辑器
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat,
	 * true));
	 *
	 * }
	 */
	// 跳转入口页面
	@RequestMapping(value = "/index.do")
	public String index() {

		return "index";
	}
	// 跳转头页面
	@RequestMapping(value = "/top.do")
	public String top() {

		return "top";
	}
	// 跳转身体页面
	@RequestMapping(value = "/main.do")
	public String main() {

		return "main";
	}
	// 跳转身体页面
	@RequestMapping(value = "/left.do")
	public String left() {

		return "left";
	}
	// 跳转身体页面
	@RequestMapping(value = "/right.do")
	public String right() {

		return "right";
	}

}
