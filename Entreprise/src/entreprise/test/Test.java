package entreprise.test;

import entreprise.model.Departement;
import entreprise.model.Employe;

public class Test {

	public static void main(String[] args) {

		//int, boolean, double, short => primitives, jamais null
		
		//Si on doit gerer les vals null =>
			//int => Integer
			//boolean => Boolean
			//double => Double
		
		//String => Wrapper / objet 
		int nb = 15;
		
		Integer nb2 = null;
		String test;
		
	
		Departement d10 = new Departement(10, "Accounting", "New York");
		Departement d20 = new Departement(20, "Research", "Dallas");
		Departement d30 = new Departement(30, "Sales", "Chicago");
		
		Employe king = new Employe(7839, "King", "President",null, 5000, null,null, d10);
		
		Employe blake = new Employe(7698, "Blake", "Manager", null, 2850,null, king, d30);
		
		Employe alen = new Employe(7499, "Allen", "Salesman",null, 1600, 300,blake, d30); 
		
		Employe turner = new Employe(7844, "Turner", "Salesman",null,  1500,0, blake, d30);
		
		
		System.out.println(king);
	
		
	}

}
