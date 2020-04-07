package com.briup.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Role;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年3月27日 下午2:43:47 
* 类说明: 
* 	从数据中查找role相关数据，提供默认的使用方法
*/
public interface RoleDao extends JpaRepository<Role, Integer>{
}
