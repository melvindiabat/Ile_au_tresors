
/**
 * @author H3
 * Cette class permet de creer une parcelle (une case de l'ile) 
 */

public class Parcelle extends Ile{
	private int id;
	private int place;
	
	/**
	 * @param s
	 *  1 Terre
	 *  2 Explorateur
	 *  3 Voleur
	 *  4 Guerrier
	 *  5 Navire
	 *  6 Rochers
	 *  7 Mer
	 *  8 Piegeur
	 *  9 Clé
	 *  10 Piège
	 *  11 Eppée 
	 *  12 coffre
	 *  13 tresor
	 */
	Parcelle(){}
	
	Parcelle(String s){
		if(s.equals("Explorateur")){this.place=2;}
		else if(s.equals("Voleur")){this.place=3;}
		else if(s.equals("Guerrier")){this.place=4;}
		else if(s.equals("Piegeur")){this.place=8;}		
	}
		
	Parcelle(int p){
		this.place=p;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public String toString(){
		return ""+this.place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
