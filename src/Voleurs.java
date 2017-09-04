import javax.swing.JOptionPane;

public class Voleurs extends Personnage {
	// ------------------------------------------------------------Méthode-----------------------------------------------------------------
	/**
	 * @param perso
	 * @return
	 */
	boolean actionsur(Personnage perso) {
		if (!perso.getInventaire().isEmpty() && !this.inventairePlein() && perso.getCamp() != this.getCamp()) {
			int saisie = Integer.valueOf(JOptionPane.showInputDialog(perso.getObjetInventaire().toString()));
			if (perso.getInventaire().get(saisie).getType() == 0 || perso.getInventaire().get(saisie).getType() == 9) {
				this.ajouterObjet(perso.getInventaire().get(saisie));
				perso.getInventaire().remove(perso.getInventaire().get(saisie));
				JOptionPane.showMessageDialog(null,"Objet obtenu !");
			}
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Il n'y a pas d'objet à prendre");
			return false;
		}
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param camp
	 */
	Voleurs(String nom, String prenom, int camp) {
		super(nom, prenom, camp);
		super.setType("Voleur");
		super.setPlace(3);
	}
	
	public void deplacer(Ile i) {
		if (super.estVivant()) {
			int echange = 0;
			int a = 1;
			int b = 1;
			String s = JOptionPane.showInputDialog(null, super.getPrenom()
					+ "\nOu souhaites-tu aller ?\n 1-Nord\n 2-Nord-Ouest\n 3-Nord-Est\n 4-Ouest\n 5-Est\n 6-Sud\n 7-Sud-Ouest\n 8-Sud-Est");
			if (s.matches("1")) {
				a = super.getX(); 
				b = super.getY() - 1;
			} else if (s.matches("2")) {
				a = super.getX() - 1;
				b = super.getY()-1;
			} else if (s.matches("3")) {
				a = super.getX() + 1;
				b = super.getY()-1;
			}else if (s.matches("4")) {
				a = super.getX() - 1;
				b = super.getY();
			} else if (s.matches("5")) {
				a = super.getX() + 1;
				b = super.getY();
			} else if (s.matches("6")) {
				a = super.getX();
				b = super.getY() + 1;
			} else if (s.matches("7")) {
				a = super.getX() - 1;
				b = super.getY() + 1;
			} else if (s.matches("8")) {
				a = super.getX() + 1;
				b = super.getY() + 1;
			}

			if (i.getJeuPlateau()[a][b] == 2) {
				this.actionsur((Personnage) i.getTableauParcelle()[a][b]);
								
			} else if ( i.getJeuPlateau()[a][b] == 5){
				JOptionPane.showMessageDialog(null, "Tu récupères ton énergie");
				super.recuperation();
				
			}else {
				while (!(i.getJeuPlateau()[a][b] == 1)) {
					JOptionPane.showMessageDialog(null, "Déplacement impossible");
					s = JOptionPane.showInputDialog(null, super.getPrenom()
							+ "\nOu souhaites-tu aller ?\n 1-Nord\n 2-Nord-Ouest\n 3-Nord-Est\n 4-Ouest\n 5-Est\n 6-Sud\n 7-Sud-Ouest\n 8-Sud-Est");
					if (s.matches("1")) {
						a = super.getX(); 
						b = super.getY() - 1;
					} else if (s.matches("2")) {
						a = super.getX() - 1;
						b = super.getY()-1;
					} else if (s.matches("3")) {
						a = super.getX() + 1;
						b = super.getY()-1;
					}else if (s.matches("4")) {
						a = super.getX() - 1;
						b = super.getY();
					} else if (s.matches("5")) {
						a = super.getX() + 1;
						b = super.getY();
					} else if (s.matches("6")) {
						a = super.getX();
						b = super.getY() + 1;
					} else if (s.matches("7")) {
						a = super.getX() - 1;
						b = super.getY() + 1;
					} else if (s.matches("8")) {
						a = super.getX() + 1;
						b = super.getY() + 1;
					}

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

	public Voleurs getVol() {
		return this;
	}
}
