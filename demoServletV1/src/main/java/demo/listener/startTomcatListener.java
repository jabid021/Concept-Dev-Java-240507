package demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import netfilm.context.Singleton;


public class startTomcatListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("Start tomcat");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {}
		
		Singleton.getInstance();
		  
    }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
     
    	System.out.println("Stop tomcat");
    	Singleton.getInstance().getEmf().close();
    }

	
    
}
