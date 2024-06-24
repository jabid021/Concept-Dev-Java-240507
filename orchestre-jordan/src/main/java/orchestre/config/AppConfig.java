package orchestre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import orchestre.model.Flutiste;
import orchestre.model.Guitariste;
import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

@Configuration
@ComponentScan({"orchestre.model","orchestre.aspect"})
//@ImportResource("classpath:application-context.xml")
@EnableAspectJAutoProxy
public class AppConfig {
	
	 @Bean
	 public IMusicien guitariste(){return new Guitariste("Jordan");}
	 
	 @Bean
	 public IMusicien pianiste(){return new Pianiste("Eric");}
	
	 @Bean
	 public IMusicien flutiste(){return new Flutiste("Olivier");}

}
