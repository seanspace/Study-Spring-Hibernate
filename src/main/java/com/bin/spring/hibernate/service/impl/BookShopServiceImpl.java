package com.bin.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bin.spring.hibernate.dao.BookShopDao;
import com.bin.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService{
	@Autowired
	private BookShopDao bookShopDao ;

	/**
	 * Spring Hibernate事务流程.
	 * 1. 在方法开始前
	 *  ① 获取Session
	 *  ②把Session和当前线程绑定,这样就可以在Dao中使用的SessionFactory的getCurrentSession()
	 *  	方法来获取Session了.
	 *  ③开启事务.
	 *  
	 *  2. 若正常结束,即没有出现异常,则
	 *  ①提交事务
	 *  ②使和当前线程绑定的Session解除绑定.
	 *  ③关闭Session
	 *  
	 *  3. 若方法出现异常,则;
	 *  ①回滚事务
	 *  ②使当前线程绑定的Session接触绑定.
	 *  ③关闭Session.
	 * 
	 */
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn) ;
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
