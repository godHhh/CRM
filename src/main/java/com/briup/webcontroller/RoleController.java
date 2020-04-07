package com.briup.webcontroller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年3月27日 上午11:50:47 
* 类说明 :
* 	角色管理模块
*/
@Controller
public class RoleController {
	//Service层
	@Autowired
	private IRoleService roleService;
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库中所有角色信息查询出来。保存到session中
		Page<Role> roles = roleService.findAllRoles();
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	@RequestMapping("saveRole")
	@ResponseBody
	public String saveRole(Role role) {
		if(role.getId()!=null) {
			roleService.saveRole(role);
			return "修改成功";
		}else {
			roleService.saveRole(role);
			return "保存成功";			
		}
	}
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex,HttpSession session) {
		Page<Role> roles = roleService.findAllRoles(pageIndex);
		session.setAttribute("roles", roles);
		return "pages/role";
	}
	//根据id，查询指定的角色
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		Optional<Role> optRole = roleService.findRoleById(id);
		Role role = optRole.orElse(null);
		return role;
	}
	@RequestMapping("delRoleById")
	@ResponseBody
	public String delRole(Integer id) {
		roleService.deleteRole(id);	
		return "删除成功";
	}
}
