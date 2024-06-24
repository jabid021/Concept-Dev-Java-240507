package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class DemoAspect {
	
	
	public void mettreTable() 
	{
		System.out.println("On met la table");
	}
	
	public void laverMains(ProceedingJoinPoint pj) throws Throwable 
	{
		System.out.println("Part se laver les mains");
		pj.proceed();
		//Pour afficher ce sysout; pj.proceed ne doit surtout pas planter
		System.out.println("Part se laver les mains pour la 2e fois");
	}
	
	public void faireVaisselle() 
	{
		System.out.println("On fait la vaisselle");
	}

	public void faireSieste() 
	{
		System.out.println("Une sieste apres un bon repas");
	}
	
	public void punition() 
	{
		System.out.println("Probleme pendant le repas....");
	}
	
	
	public void demoAvecReturnInt(int resultat) 
	{
		System.out.println(resultat);
	}
	
}
