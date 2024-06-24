package demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("demo.model")
@ImportResource("classpath:application-context.xml")
public class AppConfig {
	


}
