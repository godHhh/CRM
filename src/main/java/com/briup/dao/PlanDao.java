package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Plan;
import com.briup.bean.User;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月6日 下午7:54:10 
* 类说明 
*/
public interface PlanDao extends JpaRepository<Plan, Integer>{
	Page<Plan> findByChanceHandlerAndChanceAddress(User user,String address,Pageable able);
	Page<Plan> findByChanceHandler(User user,Pageable able);
}
