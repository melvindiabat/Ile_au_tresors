
public class Piegeur {
    private String parcelle;//Objet parcelle
    private Personnage piege;

    /**
     * @param parcelle
     * @return
     */
    boolean actionsur(String parcelle){
        if ( parcelle.equals(null)){
            //remplace le null par un trou qui bloque les perso tombé dedans
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @param nom
     * @param prenom
     * @param camp
     */
    Piegeur(String nom, String prenom, int camp){
        this.piege = new Personnage(nom,prenom);
        piege.setCamp(camp);
        piege.setType("Piegeur");
    }
}