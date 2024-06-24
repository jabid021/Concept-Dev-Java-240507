package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import orchestre.model.IMusicien;

public class Test {

	@Autowired
	IMusicien guitariste;
	
	@Autowired
	@Qualifier("pianiste")
	IMusicien musicien;
	
	
	@Autowired
	IMusicien flutiste;
	
	
	
	public void run(String[] ...args) {
	

		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//IMusicien guitariste = (IMusicien) ctx.getBean("guitariste");
		//IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		//IMusicien flutiste = (IMusicien) ctx.getBean("flutiste");
		//IMusicien flutiste2 = (IMusicien) ctx.getBean("flutisteBis");
	
		
	/*	guitariste.jouer();
		musicien.jouer();
		flutiste.jouer();
	*/
		//guitariste.toString();
		
		guitariste.jouer();
	}

}
