package JDBC;

import java.sql.*;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 02:54
 * @Notes JDBC原生调用方法，try catch, SELECT&ResultSet
 */
public class JDBCDemo4 {
    public static void main(String[] args){
        //注册驱动
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Student student;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","0419");
            //定义sql
            String sql = "SELECT * FROM studentinf";
            //获取statement对象
            statement = connection.createStatement();
            //执行
            resultSet = statement.executeQuery(sql);
            //处理结果
            while(resultSet.next()){
                student = new Student();
                student.id = resultSet.getInt(1);
                student.name = resultSet.getString(2);
                student.classes = resultSet.getInt("class");
                student.grades = resultSet.getInt("grade");
                student.age = resultSet.getInt("age");
                System.out.println(student.toString()+'A');
            }
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

            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
