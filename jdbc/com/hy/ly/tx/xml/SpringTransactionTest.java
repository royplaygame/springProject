package com.hy.ly.tx.xml;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hy.ly.tx.xml.service.BookShopDao;
import com.hy.ly.tx.xml.service.BookShopService;
import com.hy.ly.tx.xml.service.Cashier;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopDao bookShopDao = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
		bookShopService = (BookShopService) ctx.getBean("bookShopService");
		cashier = (Cashier) ctx.getBean("cashier");
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
