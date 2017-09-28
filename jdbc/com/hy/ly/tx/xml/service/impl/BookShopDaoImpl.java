package com.hy.ly.tx.xml.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hy.ly.tx.xml.service.BookShopDao;


public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "select price from book where isbn=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		String sql = "update stock set stock=stock-1 where isbn=?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sql = "update myaccount set balance=balance-? where username=?";
		jdbcTemplate.update(sql, price, username);

	}

}
