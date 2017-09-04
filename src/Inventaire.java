
import java.util.ArrayList;

public class Inventaire{
    private ArrayList<Objet> inventaire;

//-----------------------------------------------Constructeurs

    Inventaire(){
        inventaire = new ArrayList<Objet>();
    }

//-------------------------------------------------Acesseurs

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

//-------------------------------------------------Méthodes
    boolean possedeCle(){
    	for(Objet o: inventaire){
    		if(o.getType()==9){
    			return true;
    		}
    	}
    	return false;
    }
    
    boolean possedeTresor(){
    	for(Objet o: inventaire){
    		if(o.getType()==10){
    			return true;
    		}
    	}
    	return false;
    }   

    /**
     * @return
     */
    boolean inventairePlein(){
        if( inventaire.size() > 5){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param o
     */
    void ajouterObjet(Objet o){
        if(!inventairePlein()){
            inventaire.add(o);
        }
        else{
            System.out.println("Inventaire plein. Veuillez jeter un objet.");
        }
    }

    /**
     * @param o
     */
    void retirerObjet(Objet o){
        if(!inventaire.isEmpty() && o.getType() != 1 && o.getType() != 2 && o.getType() != 3 ){
            inventaire.remove(o);
        }
        else{
            System.out.println("Vous ne pouvez pas jeter un objet lorsque votre inventaire est vide où que vous possedez votre objet de départ");
        }
    }  
    
    public String toString(){
    	String rep = new String();
    	int index = 0;
    	for ( Objet o : inventaire){
    		rep += index+ " - "+o.toString() + "\n ";
    		index++;
    	}
    	return rep;
    }
}