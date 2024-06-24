package demo.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DemoRepas {
	
	
	
	public void manger(String typeRepas) throws Exception
	{
		System.out.println("On passe à table");
		Random r = new Random();
		int alea = r.nextInt(1,3);//nb alea entre [1,3[
		System.out.println(alea);
		if(alea==1) 
		{
			System.out.println("Fin du repas");
			
		}
		else 
		{
			throw new Exception("Pas de chance...");
		}
	
	}
	
	
	public void autreFonction(String demo) 
	{
		System.out.println("autre fonction");
	}
	
	public int autreFonctionAvecReturn() 
	{
		System.out.println("autre fonction avec return");
		return 42;
	}

}
