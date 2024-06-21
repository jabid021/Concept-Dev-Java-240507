package demo.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.config.AppConfig;
import demo.model.MaConfig;
import demo.model.Reference2;

public class Test {
	
	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MaConfig m = (MaConfig) ctx.getBean("maConfig");
		MaConfig m2 = (MaConfig) ctx.getBean("config2");
		System.out.println(m2.getVolume());
	//	MaConfig m2 = (MaConfig) ctx.getBean("confGlobale");
	//	MaConfig m3 = ctx.getBean("confGlobale",MaConfig.class);
		
		System.out.println(ctx.getBean(Reference2.class));
		System.out.println(m.getVolume());
		
		
	}

}
