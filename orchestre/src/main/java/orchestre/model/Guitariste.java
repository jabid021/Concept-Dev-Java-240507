package orchestre.model;

public class Guitariste implements IMusicien {

	private String prenom;
	private IInstrument instrument;
	
	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public IInstrument getInstrument() {
		return instrument;
	}




	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}


	@Override
	public void jouer() {
		System.out.println("le guitariste "+prenom+" joue ! "+instrument.son());
		
	}

	
	@Override
	public String toString() {
		return "Guitariste [prenom=" + prenom + "]";
	}

}
