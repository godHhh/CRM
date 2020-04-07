package com.briup.webcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.service.ISalesService;
import com.briup.service.IUserService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月1日 下午2:40:18 
* 类说明 
*/
@Controller
public class SalesController {
	@Autowired
	private ISalesService salesService;
	@Autowired
	private IUserService userService;
	@RequestMapping("toSales")
	public String toSales(HttpSession session,String customer,String address) {
		if("".equals(customer)) customer=null;
		if("".equals(address)) address=null;
		session.setAttribute("customer", customer);
		session.setAttribute("address", address);
		//查询商机信息
		Page<Chance> chances = salesService.findSalesByCusAndaddress(customer, address);
		session.setAttribute("chances", chances);
		List<User> jinglis = userService.findByJingli(4);
		session.setAttribute("jinglis", jinglis);
		return "pages/sales";
	}
	//分页查询
	@RequestMapping("updateSalesPage")
	public String updateSalesPage(HttpSession session,Integer pageIndex) {
		String customer = (String) session.getAttribute("customer");
		String address = (String) session.getAttribute("address");
		Page<Chance> chances = salesService.findSalesByCusAndaddress(customer, address, pageIndex);
		session.setAttribute("chances", chances);
		return "pages/sales";
	}
	//重置
	@RequestMapping("resetSales")
	@ResponseBody
	public String resetSales(HttpSession session) {
		session.removeAttribute("customer");
		session.removeAttribute("address");
		return "重置成功";
	}
	//保存和修改Chance信息
	@RequestMapping("saveSales")
	@ResponseBody
	public String saveSales(Chance chance) {
		if(chance.getId()!=null) {
			salesService.saveSales(chance);
			return "修改成功";
		}else {
			salesService.saveSales(chance);
			return "新增成功";
		}
	}
	//根据id找到对应的Chance信息
	@RequestMapping("findSalesById")
	@ResponseBody
	public Chance findSalesById(Integer id) {
		Chance chance = salesService.findSalesById(id);
		System.out.println(chance);
		return chance;
	}
	//根据id删除对应的Chance信息
	@RequestMapping("deleteSalesById")
	@ResponseBody
	public String deleteSalesById(Integer id) {
		salesService.deleteSalesById(id);
		return "删除成功";
	}
}
