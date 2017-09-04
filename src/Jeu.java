
import javax.swing.JOptionPane;

/**
 * @author H3
 * Le main qui permet de tester nos differentes classes
 */
public class Jeu{


	public static void main(String[] args) {
		Ile jeu = new Ile(13);		
		jeu.initialisationIle();		
		jeu.placementRochers(10);
		Explorateur e=new Explorateur("jk", "j1", 1);
		//Voleurs v=new Voleurs("jfj","j2",1);
		
		while(true){
			e.deplacer(jeu);
			jeu.affichage();
			//v.deplacer(jeu);  
			//jeu.affichage();
			
		}

	}

		


}

