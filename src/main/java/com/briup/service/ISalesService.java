package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月1日 下午2:45:47 
* 类说明 
*/
public interface ISalesService {
	//根据条件查询Chance信息
	Page<Chance> findSalesByCusAndaddress(String customer,String address);
	//根据分页查询Chance的相关信息
	Page<Chance> findSalesByCusAndaddress(String customer,String address,Integer pageIndex);
	//添加或修改Chance信息
	void saveSales(Chance chance);
	//根据id查询Chance信息
	Chance findSalesById(Integer id);
	//根据id删除Chance信息
	void deleteSalesById(Integer id);
	
	
	
}
