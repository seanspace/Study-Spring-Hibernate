package com.bin.spring.hibernate.dao;

public interface BookShopDao {

	
	public int findBookPriceByIsbn(String isbn) ;
	
	// 使书号对应的库存减一
	public void updateBookStock(String isbn) ;
	
	public void updateUserAccount(String username,int price) ;
	
	
}
