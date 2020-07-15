package com.briup.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月3日 下午2:48:26 
* 类说明 
*/
@Controller
public class ServiceController {
	@RequestMapping("toService")
	public String toService() {
		return "pages/service";
	}
	@RequestMapping("toServiceDetails2")
	public String toServiceDetails2() {
		return "pages/serviceDetails2";
	}
}
