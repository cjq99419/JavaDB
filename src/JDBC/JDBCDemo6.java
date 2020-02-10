package JDBC;

import java.sql.*;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 03:49
 * @Notes JDBCUtils工具类方法，try catch, PreparedStatement 预编译
 */

public class JDBCDemo6 {
    public static void main(String[] args){
        //注册驱动
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Student student;

        try {
            connection = JDBCUtils.getConnection();
            //定义sql
            String sql = "SELECT * FROM studentinf WHERE id=?";
            //获取statement对象
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                student = new Student();
                student.id = resultSet.getInt(1);
                student.name = resultSet.getString(2);
                student.classes = resultSet.getInt("class");
                student.grades = resultSet.getInt("grade");
                student.age = resultSet.getInt("age");
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
    }
}
