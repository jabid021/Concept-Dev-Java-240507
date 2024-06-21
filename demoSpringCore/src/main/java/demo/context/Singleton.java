package demo.context;

import demo.model.MaConfig;

public class Singleton {

	
	private MaConfig objetConfigGlobal = new MaConfig(50,false); 
	
	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance() 
	{
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}

	public MaConfig getObjetConfigGlobal() {
		return objetConfigGlobal;
	}

	
	

	
	
}
