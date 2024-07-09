package questRest.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import quest.config.AppConfig;

@Configuration
@EnableWebMvc
@ComponentScan("questRest.restcontrollers")
@Import(AppConfig.class)
public class WebConfig {

}
