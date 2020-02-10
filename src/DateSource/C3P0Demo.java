package DateSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 10:39
 * @Notes NULL
 */
public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
