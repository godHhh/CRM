package com.briup.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月3日 下午2:44:34 
* 类说明 
*/
@Controller
public class CustomerController {
	@RequestMapping("toCustomer")
	public String toCustomer() {
		return "pages/customer";
	}
	@RequestMapping("toLinkman")
	public String toLinkman() {
		return "pages/linkman";
	}
	@RequestMapping("toActivities")
	public String toActivities() {
		return "pages/activities";
	}
	
}
