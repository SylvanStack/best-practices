package com.yuanstack.bp.core.design.behavior.template.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: JdbcTemplate使用示例
 * @author: hansiyuan
 * @date: 2022/3/30 12:07 PM
 */
public class JdbcTemplateExample {
        private JdbcTemplate jdbcTemplate;
        public JdbcUseExampleUser queryUser(long id){
            String sql = "select * from user where id="+id;
            return jdbcTemplate.query(sql, new UserRowMapper()).get(0);
        }
        class UserRowMapper implements RowMapper<JdbcUseExampleUser> {
            @Override
            public JdbcUseExampleUser mapRow(ResultSet rs, int rowNum)throws SQLException {
                JdbcUseExampleUser user = new JdbcUseExampleUser();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setTelephone(rs.getString("telephone"));
                return user;
            }
        }
}
