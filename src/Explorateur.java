import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Explorateur extends Personnage {
	// ---------------------------------------------------------------Constructeurs---------------------------------------------------------
	/**
	 * @param nom
	 * @param prenom
	 * @param camp
	 */
	Explorateur(String nom, String prenom, int camp) {
		super(nom, prenom, camp);
		super.setType("Explorateur");
		super.setPlace(2);
	}

	ArrayList<Explorateur> listexplo;

	// ------------------------------------------------------------M�thode-----------------------------------------------------------------
	boolean peutPrendre(Objet o) {
		if (o.getType() == 1 || o.getType() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param coord
	 * @return
	 */
	boolean actionsur(Ile i,int x,int y){
		Objet cle = new Objet("Cle",9);
		Objet tresor=new Objet("tresor",10);
		if(i.getTableauParcelle()[x][y].getPlace()== 6){
			if(i.getXcle()-1==x && i.getYcle()-1==y && !this.getObjetInventaire().possedeCle()){
				JOptionPane.showMessageDialog(null,"Vous avez obtenu : " + cle.getNom());
				this.ajouterObjet(cle);
				i.setXcle(-1);i.setYcle(-1);
				return true;
			}else if(i.getXcoffre()-1==x && i.getYcoffre()-1==y && this.getObjetInventaire().possedeCle() && !this.getObjetInventaire().possedeTresor()){
				JOptionPane.showMessageDialog(null,"Vous avez obtenu : " + tresor.getNom());
				this.ajouterObjet(tresor);
				i.setXcoffre(-1);i.setYcoffre(-1);
				return true;
			}
			JOptionPane.showMessageDialog(null,"Il n'y a rien sous ce rocher !!!");

		}
		return false;
	}
			
		
		/*else if (i.getJeu()[x][y] == 9 || i.getJeu()[x][y] == 12){
			if( i.getJeu()[x][y] == 9 || i.getJeu()[x][y] == 12){
				if ( i.getJeu()[x][y] == 9){
	    			JOptionPane.showMessageDialog(null,"Vous avez obtenu : " + cle.getNom());
					//System.out.println("Vous avez obtenu : " + cle.getNom());
					this.getInventaire().ajouterObjet(cle);
					return true;
				}
		
				else {
	    			JOptionPane.showMessageDialog(null,"Vous avez obtenu : " + super.toString());
					//System.out.println("Vous avez obtenu : " + super.toString());
					super.setPlace(5);
					return true;
				}
			}
			else{
    			JOptionPane.showMessageDialog(null,"Il n'y a pas de clé sous ce rocher");
				//System.out.println("Il n'y a pas de clé sous ce rocher");
				return true;
			}
		}
		return false;*/
		
	

	/**
	 * @param i
	 */
	public void deplacer(Ile i) {
		if (super.estVivant()) {
			int echange = 0;
			int a = 1;
			int b = 1;
			String s = JOptionPane.showInputDialog(null,
					super.getPrenom() + "\nOu souhaites-tu aller ?\n 1-Nord\n 2-Ouest\n 3-Est\n 4-Sud\n Il te reste: "+super.getEnergie()+" d'énergie");
			if (s.matches("1")) {
				a = super.getX(); 
				b = super.getY() - 1;
			} else if (s.matches("2")) {
				a = super.getX() - 1;
				b = super.getY();
			} else if (s.matches("3")) {
				a = super.getX() + 1;
				b = super.getY();
			} else if (s.matches("4")) {
				a = super.getX();
				b = super.getY() + 1;
			}

			if (i.getJeuPlateau()[a][b] == 6 || i.getJeuPlateau()[a][b] == 9) {
				this.actionsur(i, a, b);
				
			} else if ( i.getJeuPlateau()[a][b] == 5){
				JOptionPane.showMessageDialog(null, "Tu récupères ton énergie");
				super.recuperation();
				
				//this.setJeu();
				
			}else {
				while (!(i.getJeuPlateau()[a][b] == 1)) {
					JOptionPane.showMessageDialog(null, "Déplacement impossible");
					s = JOptionPane.showInputDialog(null,
							super.getPrenom() + "\nOu souhaites-tu aller ?\n 1-Nord\n 2-Ouest\n 3-Est\n 4-Sud\n Il te reste: "+super.getEnergie()+" d'énergie");
					if (s.matches("1")) {
						a = super.getX();
						b = super.getY() - 1;
					} else if (s.matches("2")) {
						a = super.getX() - 1;
						b = super.getY();
					} else if (s.matches("3")) {
						a = super.getX() + 1;
						b = super.getY();
					} else if (s.matches("4")) {
						a = super.getX();
						b = super.getY() + 1;
					}
					echange = i.getJeuPlateau()[a - 1][b - 1];
				}

				try {
					Thread.sleep(100);
				} catch (Exception ie) {
				}
				if ( i.getJeuPlateau()[super.getX()][super.getY()] == 5){
					i.getTableauParcelle()[a][b] = this;
					i.getTableauParcelle()[super.getX()][super.getY()] = new Parcelle(5);
					super.setX(a);
					super.setY(b);
					i.setJeu();
				}else {
					i.getTableauParcelle()[a][b] = this;
					i.getTableauParcelle()[super.getX()][super.getY()] = new Parcelle(1);
					super.setEnergie(super.getEnergie() - 1);
					super.setX(a);
					super.setY(b);
					i.setJeu();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Tu n'as plus d'énergie !!!!");
		}

	}


	// ---------------------------------------------------------------------Acesseur------------------------------------------------------------------

	/**
	 * @return
	 */
	public Explorateur getExplo() {
		return this;
	}

}
