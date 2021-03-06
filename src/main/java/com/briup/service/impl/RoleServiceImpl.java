package com.briup.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.dao.RoleDao;
import com.briup.service.IRoleService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年3月27日 下午2:43:05 
* 类说明 
*/
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private RoleDao roleDao;
	@Override
	public Page<Role> findAllRoles() {
		//查询刚进入角色管理模块（第一页）的所有角色
		return findAllRoles(0);
	}

	@Override
	public Page<Role> findAllRoles(int pageIndex) {
		//指定查看第几页数据，并且指定一页显示多少条数据
		Page<Role> page = roleDao.findAll(PageRequest.of(pageIndex, 2));
		return page;
	}

	@Override
	public void saveRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public Optional<Role> findRoleById(Integer id) {
		return roleDao.findById(id);
	}


	@Override
	public void deleteRole(Integer id) {
		roleDao.deleteById(id);
	}

	@Override
	public List<Role> allRoles() {
		return roleDao.findAll();
	}

}
