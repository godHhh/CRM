package com.briup.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年7月15日 上午10:44:19 
* 类说明 
*/
@Controller
public class FeedbackController {
	@RequestMapping("toFeedback")
	public String toService() {
		return "pages/feedback";
	}
	@RequestMapping("toServiceDetails")
	public String toServiceDetails() {
		return "pages/serviceDetails";
	}
}
