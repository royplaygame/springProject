package com.hy.ly.tx.xml.service.impl;

import com.hy.ly.tx.xml.service.BookShopDao;
import com.hy.ly.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}

	@Override
	public void purchase(String username, String isbn) {

		// 1. 获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);

		// 2. 更新库存
		bookShopDao.updateBookStock(isbn);

		// 3. 更新用户余额
		bookShopDao.updateUserAccount(username, price);

	}

}
