package com.hy.ly.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.hy.ly.po.AdminUser;

public class JDBCTest {

	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}

	/**
	 * 1. 有多个参数，可以给参数启名称，看起来比较容易对照，便于维护。 2. 缺点较为麻烦。需要额外定义一个Map
	 */
	@Test
	public void testNamedParameterJdbcTemplate() {
		String sql = "insert into adminac values(seq_admin.nextval,:name,:pwd)";

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", "bailongm");
		paramMap.put("pwd", "666666");

		int row = namedParameterJdbcTemplate.update(sql, paramMap);
		System.out.println(row);
	}

	/**
	 * 这种方式就比较好,使用具名参数时，可以使用update(sql, paramSource)方法来操作。
	 * SQL语句中的参数名称，和类的属性名称一致。 SqlParameterSource paramSource做为参数。
	 */
	@Test
	public void testNamedParameterJdbcTemplate2() {
		String sql = "insert into adminac values(seq_admin.nextval,:adminName,:adminPwd)";

		AdminUser admin = new AdminUser(1000, "zhubajie", "555555");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(admin);
		int row = namedParameterJdbcTemplate.update(sql, paramSource);
		System.out.println(row);
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

	// 增、删、改操作
	@Test
	public void testUpdate() {
		String sql = "update adminac set adminname=?,adminpwd=? where adminnumber=?";
		Object[] args = { "zhaoyun", "123456", 1025 };
		int row = jdbcTemplate.update(sql, args);
		System.out.println("更新成功！" + row);

	}

	@Test
	public void testAdd() {
		String sql = "insert into adminac values(seq_admin.nextval,?,?)";
		Object[] args = { "zhuge", "123456" };
		int row = jdbcTemplate.update(sql, args);
		System.out.println("添加成功！" + row);

	}

	@Test
	public void testDelete() {
		String sql = "delete from adminac where adminnumber=?";
		Object[] args = { 1003 };
		int row = jdbcTemplate.update(sql, args);
		System.out.println("删除成功！" + row);

	}

	// 执行批量更新,增、删、改操作
	@Test
	public void testBatchUpdate() {
		String sql = "insert into adminac values(seq_admin.nextval,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[] { "caocao", "1111111" });
		batchArgs.add(new Object[] { "sunquan", "1111111" });
		batchArgs.add(new Object[] { "liubei", "123456" });
		int[] rows = jdbcTemplate.batchUpdate(sql, batchArgs);
		System.out.println(Arrays.toString(rows));
	}

	// 从数据库得到一条记录，实际是一个对象,可以使用指定列的别名和属性名的映射关系。
	// queryForObject(String sql, RowMapper<AdminUser> rowMapper, Object...
	// args)
	@Test
	public void testQueryForObject() {
		String sql = "select adminnumber adminno,adminname,adminpwd from adminac where adminnumber=?";
		RowMapper<AdminUser> rowMapper = new BeanPropertyRowMapper<>(AdminUser.class);
		AdminUser admin = jdbcTemplate.queryForObject(sql, rowMapper, 1025);
		System.out.println(admin);
	}

	// 查询一组对象
	@Test
	public void testQueryForList() {
		String sql = "select adminnumber adminno,adminname,adminpwd from adminac where adminnumber>?";
		RowMapper<AdminUser> rowMapper = new BeanPropertyRowMapper<>(AdminUser.class);
		List<AdminUser> adminUsers = jdbcTemplate.query(sql, rowMapper, 1026);
		for (AdminUser admin : adminUsers) {
			System.out.println(admin);
		}
	}

	// 获取单个列的值，或者做统计查询
	@Test
	public void testQueryForOneObject() {
		String sql = "select count(*) from adminac where adminnumber>?";
		long count = jdbcTemplate.queryForObject(sql, Long.class, 1026);
		System.out.println(count);
	}

	// 获取单个列的值，或者做统计查询
	// queryForObject(String sql, Class<String> requiredType, Object... args)
	@Test
	public void testQueryForOneObject2() {
		String sql = "select adminname from adminac where adminnumber=?";
		String adminName = jdbcTemplate.queryForObject(sql, String.class, 1026);
		System.out.println(adminName);
	}
}
