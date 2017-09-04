

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author H3
 * Cette classe permet la création d'un personnage avec ses propres caractéristiques:
 * non,prénom,énergie,camp,type.
 *
 */
public class Personnage extends Parcelle{
    private String nom,prenom;
    private int energie;
    private boolean IsAlive;
    private int x,y;
    private int camp;
    private Inventaire inv;
    private String type;

    //-----------------------------------------------------------Acesseurs----------------------------------------------------------------

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Objet> getInventaire() {
        return inv.getInventaire();
    }
    
    public Inventaire getObjetInventaire() {
    	return inv;
    }
    
    public boolean inventairePlein() {
    	return this.inv.inventairePlein();
    }
    
    public void ajouterObjet(Objet o){
    	this.inv.ajouterObjet(o);
    }

    public void setEnergie(int energie){
        this.energie = energie;
    }

    public int getEnergie(){
        return this.energie;
    }

    public void setCamp(int camp){
        this.camp = camp;
    }

    public int getCamp(){
        return this.camp;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

    //------------------------------------------------------------Méthode-----------------------------------------------------------------

	Personnage(){}
    
    /**
     * Création d'un personnage a partir de son nom et prénom.
     * @param nom
     * @param prenom
     */
    Personnage(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.energie = 100;
        this.IsAlive = true;
        this.inv = new Inventaire();
        
    }
    
    Personnage(String nom, String prenom, int camp){
    	this(nom,prenom);
    	  if (camp==1){
    	    this.setX(0);
    	    this.setY(1);
    	  }else if(camp==2){
    	    this.setX(9);
    	    this.setY(8);
    	  }
    	  this.camp=camp;
    }

    /**
     * Vérifie au coordonée x,y qu'il sagit du navire du personnage.
     * @param x
     * @param y
     */
    public boolean estSonNavire(int x,int y){
        boolean res=false;
    	if(this.getCamp()==1 && x==1 && y==2){ res=true;}
    	else if(this.getCamp()==2 && x==10 && y==9){res=true;}
    	return res;
    }


    /**
     * Nous indique si le personnage est toujours vivant.
     */
    public boolean estVivant(){
        if ( this.energie == 0){
            IsAlive = false;
        }
        return IsAlive;
    }
    
    void recuperation(){
			if ( this.getEnergie() > 90){
				this.setEnergie(100);
			}else {
				this.setEnergie(this.getEnergie() + 10);
			}
    }
}