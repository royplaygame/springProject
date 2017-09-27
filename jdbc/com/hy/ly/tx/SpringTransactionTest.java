package com.hy.ly.tx;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(Cashier.class);
	}

	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		int price = bookShopDao.findBookPriceByIsbn("1001");
		System.out.println(price);
	}

	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}

	@Test
	public void testBookShopDaoUpdateUserAccount() {
		bookShopDao.updateUserAccount("lilei", 200);
	}

	// 测试事务
	@Test
	public void testBookShopService() {
		// 账号lilei购买 1001号图书
		bookShopService.purchase("lilei", "1001");
	}

	// 测试事务的传播行为
	@Test
	public void testTransactionalPropagation() {
		cashier.checkout("lilei", Arrays.asList("1001", "1002"));
	}
}
