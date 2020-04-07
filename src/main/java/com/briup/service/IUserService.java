package com.briup.service;
/** 
* @author 作者 lyh: 
* @version 创建时间：2020年3月26日 下午4:47:54 
* 类说明 
*/


import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;

public interface IUserService {
	public User findByName(String name);
	//新增和修改用户
	void saveUser(User user);
	//通过id找到对应用户
	User findUserById(Integer id);
	//通过id删除对应用户
	void deleteUserById(Integer id);
	//查询User信息
	Page<User> findUsersByRole(Integer roleId);
	//根据分页查询User的相关信息
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	
	List<User> findByJingli(Integer id);
}
