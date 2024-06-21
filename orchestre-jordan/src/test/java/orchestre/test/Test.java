package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {
	

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		IMusicien guitariste = (IMusicien) ctx.getBean("guitariste");
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste = (IMusicien) ctx.getBean("flutiste");
		//IMusicien flutiste2 = (IMusicien) ctx.getBean("flutisteBis");
	
		
		guitariste.jouer();
		pianiste.jouer();
		flutiste.jouer();
	}

}
