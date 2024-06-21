package demo.model;

public class MaConfig {

	private int volume;
	private boolean fenetre;
	private Reference2 ref;
	
	public MaConfig() 
	{
		this.fenetre=false;
	}


	public MaConfig(int volume, boolean fenetre) {
		this.volume = volume;
		this.fenetre = fenetre;
	}


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public boolean isFenetre() {
		return fenetre;
	}


	public void setFenetre(boolean fenetre) {
		this.fenetre = fenetre;
	}


	public Reference2 getRef() {
		return ref;
	}


	public void setRef(Reference2 ref) {
		this.ref = ref;
	}
	
	
	
}
