import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.applet.Main;

/**
 * @author Bruce
 * @create 2020-08-29 14:45
 */
public class TestJdbcTemplateOfAnnotation {

    @Autowired
    private static JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
    }
}
