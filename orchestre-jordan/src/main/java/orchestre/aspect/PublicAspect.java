package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {

	
	 public void installer(){System.out.println("Le public s'installe");}
	 
	 public void applaudir(){System.out.println("Le public applaudit");}
	 
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
