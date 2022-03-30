package com.yuanstack.bp.core.design.behavior.template.jdbc;

import java.sql.*;

/**
 * @description: Jdbc使用示例
 * @author: hansiyuan
 * @date: 2022/3/30 11:55 AM
 */
public class JdbcUseExample {
    public JdbcUseExampleUser queryUser(long id) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bp", "admin", "admin");
            //2.创建statement类对象，用来执行SQL语句
            stmt = conn.createStatement();
            //3.ResultSet类，用来存放获取的结果集
            String sql = "select * from user where id=" + id;
            ResultSet resultSet = stmt.executeQuery(sql);
            String eid = null, ename = null, price = null;
            while (resultSet.next()) {
                JdbcUseExampleUser user = new JdbcUseExampleUser();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                return user;
            }
        } catch (ClassNotFoundException e) {
            // TODO: log...
        } catch (SQLException e) {
            // TODO: log...
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO: log...
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO: log...
                }
            }
        }
        return null;
    }
}
