package com.briup.webcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.bean.User;
import com.briup.dao.PlanDao;
import com.briup.dao.SalesDao;
import com.briup.service.IPlanService;
import com.briup.service.ISalesService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月3日 下午2:42:22 
* 类说明 
*/
@Controller
public class PlanController {
	@Autowired
	private IPlanService planService;
	@Autowired
	private ISalesService saleService;
	@RequestMapping("toPlan")
	public String toPlan(HttpSession session,String address) {
		User user = (User) session.getAttribute("user");
		Page<Plan> plans = planService.findByChanceHandlerAndChanceAddress(user, address);
		session.setAttribute("plans", plans);
		return "pages/plan";
	}
}
