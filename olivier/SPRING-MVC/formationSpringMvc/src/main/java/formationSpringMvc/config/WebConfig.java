package formationSpringMvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("formationSpringMvc.controllers")
public class WebConfig {

	// recupere le String renvoye par le controller
	// dans l'exemple "hello"
	// PREFIXhelloSUFFIX =>le string pour le RequestDispatcher
	// utile que pour le modele MVC
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class); // views utilise la jstl
		return viewResolver;
	}
}
