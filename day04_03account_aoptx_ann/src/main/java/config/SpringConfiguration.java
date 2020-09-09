package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Bruce
 * @create 2020-09-07 14:36
 */
@Configuration
@ComponentScan("cn.bruce")
@Import(JdbcConfig.class)
@PropertySource("jdbcConfig.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration {
}
