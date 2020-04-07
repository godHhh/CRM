package com.briup.service;

import org.springframework.data.domain.Page;

import com.briup.bean.Plan;
import com.briup.bean.User;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月3日 下午3:15:27 
* 类说明 
*/
public interface IPlanService {
	Page<Plan> findByChanceHandlerAndChanceAddress(User user,String address);
	Page<Plan> findByChanceHandlerAndChanceAddress(User user,String address,Integer pageIndex);
}
