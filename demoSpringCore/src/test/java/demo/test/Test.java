package demo.test;

import org.springframework.beans.factory.annotation.Autowired;

import demo.aspect.DemoAspect;
import demo.model.DemoRepas;

public class Test {
	
	@Autowired
	DemoRepas demo;
	
	@Autowired
	DemoAspect aspect;
	
	public void run(String[] ...args) {
		
		try {
		demo.manger("Vegetarien");
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\n\n");
		demo.autreFonction("");
		
		System.out.println("\n\n");
		demo.autreFonctionAvecReturn();
		
	}

}
