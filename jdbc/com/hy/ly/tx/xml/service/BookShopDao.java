package com.hy.ly.tx.xml.service;

public interface BookShopDao {

	// 根据书的编号，获取书的单价
	public int findBookPriceByIsbn(String isbn);

	// 更新库存，使对应书的编号的库存-1
	public void updateBookStock(String isbn);

	// 更新用户帐户余额，根据用户名称，更新用户的余额。
	public void updateUserAccount(String username, int price);
}
