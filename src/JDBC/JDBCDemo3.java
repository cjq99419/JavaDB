package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 02:48
 * @Notes JDBC原生调用方法，try catch, INSERT
 */
public class JDBCDemo3 {
    public static void main(String[] args){
        //注册驱动
        Statement statement = null;
        Connection connection = null;
        int count;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","0419");
            //定义sql
            String sql = "INSERT INTO `student`.`studentinf` VALUES ('4', 'lgh', '3', '3', '19');";
            //获取statement对象
            statement = connection.createStatement();
            //执行
            count = statement.executeUpdate(sql);
            //处理结果
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            //释放资源
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
