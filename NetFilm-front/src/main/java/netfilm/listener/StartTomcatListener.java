package netfilm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import netfilm.context.Singleton;


@WebListener
public class StartTomcatListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {}
		
		Singleton.getInstance();
		  
    }
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	Singleton.getInstance().getEmf().close();
    }

	
    
}
