package JDBCTemplate;

import DateSource.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.rowset.JdbcRowSet;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/2/8 0008 下午 06:33
 * @Notes JDBCTemplate示例 update
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update studentinf set age=20 where id=?";
        int count = jdbcTemplate.update(sql,2);
        System.out.println(count);
    }

}
