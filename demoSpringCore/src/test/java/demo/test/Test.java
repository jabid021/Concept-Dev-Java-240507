package demo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.model.MaConfig;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		MaConfig m = ctx.getBean(MaConfig.class);
	//	MaConfig m2 = (MaConfig) ctx.getBean("confGlobale");
	//	MaConfig m3 = ctx.getBean("confGlobale",MaConfig.class);
		
		System.out.println(m.getVolume());
		
		
	}

}
