package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.SalesDao;
import com.briup.service.ISalesService;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月1日 下午2:51:42 
* 类说明 
*/
@Service
public class SalesServiceImpl implements ISalesService{
	@Autowired
	private SalesDao salesDao;
	@Override
	public Page<Chance> findSalesByCusAndaddress(String customer, String address) {
		return findSalesByCusAndaddress(customer, address, 0);
	}

	@Override
	public Page<Chance> findSalesByCusAndaddress(String customer, String address, Integer pageIndex) {
		Page<Chance> chances = null;
		if(customer==null&&address!=null) {
			 chances = salesDao.findByAddress(address, PageRequest.of(pageIndex, 2));
		}else if(address==null&&customer!=null) {
			chances = salesDao.findByCustomerContaining(customer, PageRequest.of(pageIndex, 2));
			System.out.println("t------");
		}else if(address!=null&&customer!=null) {
			chances = salesDao.findByCustomerAndAddress(customer, address, PageRequest.of(pageIndex, 2));
		}else {
			chances = salesDao.findAll(PageRequest.of(pageIndex, 2));
		}
		return chances;
	}
	
	@Override
	public void saveSales(Chance chance) {
		 salesDao.save(chance);
	}

	@Override
	public Chance findSalesById(Integer id) {
		return salesDao.getOne(id);
	}

	@Override
	public void deleteSalesById(Integer id) {
		salesDao.deleteUserById(id);
	}

	

	

}
