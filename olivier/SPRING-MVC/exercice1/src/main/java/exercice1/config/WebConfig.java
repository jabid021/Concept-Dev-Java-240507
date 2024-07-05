package exercice1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("exercice1.controllers")
@EnableWebMvc
public class WebConfig {

	@Bean
	public UrlBasedViewResolver viewResorlver() {
		UrlBasedViewResolver uBVR = new UrlBasedViewResolver();
		uBVR.setViewClass(JstlView.class);
		uBVR.setSuffix(".jsp");
		uBVR.setPrefix("/WEB-INF/views/");
		return uBVR;
	}
}
