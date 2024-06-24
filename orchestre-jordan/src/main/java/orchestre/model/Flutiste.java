package orchestre.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Flutiste implements IMusicien {

	private String prenom;
	
	@Autowired
	private IInstrument flute;
	
	public Flutiste() {}
	
	
	
	public Flutiste(String prenom) {
		this.prenom = prenom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public IInstrument getFlute() {
		return flute;
	}



	public void setFlute(IInstrument flute) {
		this.flute = flute;
	}



	@Override
	public void jouer() {
		System.out.println("Le flutiste "+prenom+" joue ! "+flute.son());
		
	}

}
