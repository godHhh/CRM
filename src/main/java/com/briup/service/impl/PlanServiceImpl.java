package com.briup.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.Plan;
import com.briup.bean.User;
import com.briup.dao.PlanDao;
import com.briup.service.IPlanService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月6日 下午8:01:00 
* 类说明 
*/
@Service
public class PlanServiceImpl implements IPlanService{
	@Autowired
	private PlanDao planDao;
	@Override
	public Page<Plan> findByChanceHandlerAndChanceAddress(User id, String address) {
		return findByChanceHandlerAndChanceAddress(id, address, 0);
	}

	@Override
	public Page<Plan> findByChanceHandlerAndChanceAddress(User id, String address, Integer pageIndex) {
		Page<Plan> plans = null;
		if(address!=null&&!"".equals(address)) {			
			plans = planDao.findByChanceHandlerAndChanceAddress(id, address, PageRequest.of(pageIndex, 2));
		}else {
			plans = planDao.findByChanceHandler(id, PageRequest.of(pageIndex, 5));
		}
		return plans;
	}
	


}
