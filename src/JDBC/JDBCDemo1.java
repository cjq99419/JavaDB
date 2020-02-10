package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 02:15
 * @Notes JDBC原生调用方法，throws
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","0419");
        //定义sql
        String sql = "update studentinf set age=25 where id=1";
        //获取statement对象
        Statement statement = connection.createStatement();
        //执行
        int count = statement.executeUpdate(sql);
        //处理结果
        System.out.println(count);
        //释放资源
        statement.close();
        connection.close();
    }
}
