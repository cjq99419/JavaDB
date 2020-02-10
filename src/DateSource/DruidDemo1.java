package DateSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/7 0007 下午 10:53
 * @Notes 原生Druid连接池
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream in = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(in);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
