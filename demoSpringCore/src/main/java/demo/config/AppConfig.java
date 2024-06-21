package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import demo.model.MaConfig;

@Configuration
@ComponentScan("demo.model")
public class AppConfig {
	
	@Bean
	public MaConfig config2() 
	{
		return new MaConfig(100,false); 
	}

}
