import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	
	public static void ecrire() 
	{
		Employe emp1 = new Employe("Doe", "John", 40);
		Employe emp2 = new Employe("Doe", "Jane", 40);
		Employe emp3 = new Employe("Abid", "Jordan", 31);
		
		
		List<Employe> employes = new ArrayList();
		Collections.addAll(employes, emp1,emp2,emp3);
		
		File f = new File("fichier.txt");
		try(	
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			) 
		{
		
			oos.writeObject(employes);

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void lire() 
	{
		
		
	
		File f = new File("fichier.txt");
		try(	
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			) 
		{
			System.out.println(ois.readObject());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		lire();
		
		
		
		
		
		

	}

}
