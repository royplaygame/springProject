package com.hy.ly.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	/**
	 * 1.
	 * 使用用(propagation=Propagation.REQUIRED)指定事务的传播行为，即当前事务方法被另外一个事务方法调用时,如何使用事务
	 * 事务的默认传播行为是：Propagation.REQUIRED，即使用调用方法的事务。
	 * REQUIRES_NEW:使用自己的事务，调用的事务方法的事务被挂起。
	 * 
	 * 2. isolation：指定事务的隔离级别，常用的是：Isolation.READ_COMMITTED
	 * 
	 * 3. 默认情况下，声明式事务对所有运行时异常进行回滚，也可以对应属性进行设置。通常情况为默认值 noRollbackFor =
	 * {DataIntegrityViolationException.class }
	 * 
	 * 4. readOnly=false,帮助数据引擎优化
	 * 5. timeout=1,
	 */
	// 添加事务注解
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
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
