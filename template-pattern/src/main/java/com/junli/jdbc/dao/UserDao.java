package com.junli.jdbc.dao;

import com.junli.jdbc.JdbcTemplate;
import com.junli.jdbc.entity.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author lijun
 * @since 2018-03-19 15:35
 */
public class UserDao {

    /**
     * 为什么不继承，主要是为了解耦
     */
    public JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query(){
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws Exception {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setAddr(rs.getString("addr"));
                return user;
            }
        },null);
    }


}