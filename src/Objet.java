
public class Objet extends Inventaire{
    private String nom;
    private int type;// 9 = Clé; 10 = Piège; 11 = Eppée; 12 coffre; 13 tresors

    Objet(String prenom,int type){
    	this.type = type;
    	this.nom = prenom;
    }
    //---------------------------------------------------------------------Acesseur------------------------------------------------------------------
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getType() {
        return type;
    }

    //-------------------------------------------------------------------------Méthodes------------------------------------------------------------------
    void appartientA(Personnage coucou){
        if( this.type == 10 && coucou.getType() == "Piegeur"){
            coucou.getInventaire().add(this);
        }
        else if( this.type == 9 && coucou.getType() == "Explorateur"){
            coucou.getInventaire().add(this);
        }
        else if( this.type == 11 && coucou.getType() == "Guerrier"){
            coucou.getInventaire().add(this);
        }
        if ( this.type != 11 || this.type != 10 || this.type != 9){
            coucou.getInventaire().add(this);
        }
    }
    
	 public String toString(){
		 return nom;
	 }
}