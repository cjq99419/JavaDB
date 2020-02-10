package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 03:24
 * @Notes JDBCUtils工具类方法，try catch, 事务管理
 */
public class JDBCDemo7 {
    public static void main(String[] args){
        //注册驱动
        Statement statement = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql1 = "update studentinf set age=20 where id=1";
            String sql2 = "update studentinf set age=25 where id=4";
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.executeUpdate(sql1);
            //int a = 3/0;
            statement.executeUpdate(sql2);
            connection.commit();
        } catch (SQLException e) {
            try {
                if(connection != null )
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, statement);
        }
    }
}
