package DateSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/8 0008 下午 01:37
 * @Notes 调用Druid工具类JDBCUtils
 */

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO `student`.`studentinf` VALUES ('5', 'ls', '3', '3', '18');";
            statement = connection.createStatement();
            boolean result = statement.execute(sql);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(connection, statement);
        }
    }
}
