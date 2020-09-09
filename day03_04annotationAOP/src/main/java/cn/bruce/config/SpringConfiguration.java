package cn.bruce.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.bruce")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfiguration {
}
