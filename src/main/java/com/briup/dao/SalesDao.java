package com.briup.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 lyh: 
* @version 创建时间：2020年4月1日 下午2:53:07 
* 类说明 
*/
public interface SalesDao extends JpaRepository<Chance, Integer>{
	//Containing：模糊查询
	Page<Chance> findByCustomerContaining(String customer,Pageable able);
	Page<Chance> findByAddress(String address,Pageable able);
	Page<Chance> findByCustomerAndAddress(String customer,String address,Pageable able);
	@Transactional
	@Modifying
	@Query("delete from Chance c where c.id=?1")
	void deleteUserById(Integer id);
	
	
}
