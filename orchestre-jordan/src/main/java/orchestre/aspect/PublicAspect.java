package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {


	@Pointcut("execution(public void orchestre.model.Guitariste.jouer())")
	public void aspectJouer() {}


	@Before("aspectJouer()")
	public void installer(){System.out.println("Le public s'installe");}

	@AfterReturning("aspectJouer()")
	public void applaudir(){System.out.println("Le public applaudit");}

	@AfterThrowing("aspectJouer()")
	public void huer(){System.out.println("Le public jette des tomates");}




	@Pointcut("execution(public String orchestre.model.Guitariste.toString())")
	public void monCheminToString() {}

	@AfterReturning(pointcut="monCheminToString()",returning="msg")
	public void afterToStringGuitariste(String msg) 
	{
		System.out.println(msg);
		System.out.println("Le guitariste vient de se presenter");
	}

	/*
	 @AfterReturning(pointcut="execution(public String orchestre.model.Guitariste.toString())",returning="msg")
	public void afterToStringGuitariste(String msg) 
	{
		System.out.println(msg);
		System.out.println("Le guitariste vient de se presenter");
	}*/
}
