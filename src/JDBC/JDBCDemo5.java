package JDBC;

import java.sql.*;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 03:24
 * @Notes JDBCUtils工具类方法，try catch, SELECT&ResultSet
 */
public class JDBCDemo5 {
    public static void main(String[] args){
        //注册驱动
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Student student;

        try {
            connection = JDBCUtils.getConnection();
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
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(connection, statement, resultSet);
        }
    }
}
