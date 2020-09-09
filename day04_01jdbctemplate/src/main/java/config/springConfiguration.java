package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Bruce
 * @create 2020-08-29 10:07
 */
@Configuration
@ComponentScan("cn.bruce")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class springConfiguration {
}
