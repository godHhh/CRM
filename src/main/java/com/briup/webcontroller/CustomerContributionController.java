package com.briup.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月3日 下午3:02:28 
* 类说明 
*/
@Controller
public class CustomerContributionController {
	@RequestMapping("toCustomerContribution")
	public String toCustomerContribution() {
		return "pages/customerContribution";
	}
}
