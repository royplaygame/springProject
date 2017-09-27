package com.hy.ly.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hy.ly.po.AdminUser;

@Repository
public class AdminUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AdminUser getAdminUserById(Integer adminNo) {
		String sql = "select adminnumber adminno,adminname,adminpwd from adminac where adminnumber=?";
		RowMapper<AdminUser> rowMapper = new BeanPropertyRowMapper<>(AdminUser.class);
		AdminUser admin = jdbcTemplate.queryForObject(sql, rowMapper, adminNo);
		return admin;
	}

	public int addAdminUser(AdminUser admin) {
		String sql = "insert into adminac values(seq_admin.nextval,?,?)";
		Object[] args = { admin.getAdminName(), admin.getAdminPwd() };
		int row = jdbcTemplate.update(sql, args);
		return row;
	}
}
