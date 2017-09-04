
public class Guerrier extends Personnage{
	private int force;
	//---------------------------------------------------------------Constructeurs---------------------------------------------------------
	/**
	 * @param nom
	 * @param prenom
	 * @param camp
	 */
	Guerrier(String nom, String prenom, int camp){
		super(nom,prenom,camp);
		super.setType("Guerrier");
		this.force = 10;
	}
	
	//------------------------------------------------------------Méthode-----------------------------------------------------------------

	void actionsur(Personnage perso){
		perso.setEnergie(perso.getEnergie()-force);
	}

	boolean peutPrendre(Objet o){
		if ( o.getType() == 3 || o.getType() == 0){
			return true;
		}
		else {
			return false;
		}
	}
	//---------------------------------------------------------------------Acesseurs------------------------------------------------------------------


	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}
}
