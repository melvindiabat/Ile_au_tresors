
import java.util.Random;
import tps.Plateau;

/**
 * @author H3
 * Cette classe permet la création d'une ile (plateau de jeu)
 *
 */
public class Ile{
	private Plateau p;
	private Parcelle[][] jeu;
	private String[] images= {"images/terre.png","images/explorateur.png","images/voleur.png","images/guerier.png","images/navire.png","images/rocher.png","images/mer.png","images/piegeur.png","images/cle.jpg","images/coffre.jpg"};
	private final int taille;
	private int xcle,ycle,xcoffre,ycoffre;

	public int getXcle() {
		return xcle;
	}

	public void setXcle(int xcle) {
		this.xcle = xcle;
	}

	public int getYcle() {
		return ycle;
	}

	public void setYcle(int ycle) {
		this.ycle = ycle;
	}

	public int getXcoffre() {
		return xcoffre;
	}

	public void setXcoffre(int xcoffre) {
		this.xcoffre = xcoffre;
	}

	public int getYcoffre() {
		return ycoffre;
	}

	public void setYcoffre(int ycoffre) {
		this.ycoffre = ycoffre;
	}

	Ile(){taille=0;}

	/**
	 * Création d'une ile carrée a partir d'une taille.
	 * @param taille
	 */
	Ile(int taille){
		this.p=new Plateau(images,taille);
		this.jeu=new  Parcelle[taille][taille];
		this.taille=taille;

		for (int i = 0; i < jeu.length; i++) {
			for (int j = 0; j < jeu.length; j++) {
				jeu[i][j] = new Parcelle(0);
			}
		}

	}

	public Parcelle[][] getTableauParcelle() {
		return this.jeu;
	}

	public int[][] getJeuPlateau() {
		return p.getJeu();
	}

	public void setJeu() {
		p.setJeu(this.parcelle2Int());
	}


	public void affichage() {		
		p.affichage();
	}


	/**
	 * Vérifie au coordonée x,y que la parcelle(place) est vide
	 * @param x
	 * @param y
	 */
	boolean estVide(int x, int y){
		if(jeu[x][y].getPlace() == 0 || jeu[x][y].getPlace() == 1){
			return true;
		}
		return false;
	}

	/**
	 * Ajoute au coordonée x,y une nouvelle parcelle si la place est vide
	 * @param x
	 * @param y
	 * @param s
	 */
	/*void add(int x,int y, Parcelle s){
		if(estVide(x-1,y-1)){
			this.jeu[x-1][y-1]=s.getPlace();
		}
		this.setJeu(jeu);
	}*/

	/**
	 * placement des rochers sur l'ile selon un pourcentange de remplisage
	 * @param nb
	 */
	void placementRochers(int nb){
		Random r=new Random();
		int nombreRochers = (((taille*taille)*nb)/100); 
		int x = 0, y = 0;
		for(int i=1;i<taille-1;i++){
        	for(int j=1;j<taille-1;j++){
        		if(this.jeu[i][j].getPlace()==9 || this.jeu[i][j].getPlace()==10){
        			this.jeu[i][j].setPlace(6);
        			nombreRochers--;
        		}
        	}
        }
		while(nombreRochers > 0){
			x = r.nextInt(taille);
			y = r.nextInt(taille);

			if(r.nextInt() > 0.5 && estVide(x,y) && x!=1 && y!=1 && x!=taille-2 && y!=taille-2){
				this.jeu[x][y] = new Parcelle(6);
				nombreRochers--;

			}
		}
		this.parcelle2Int();
		this.setJeu();
	}

	
	public int[][] parcelle2Int() {
		int[][] temp = new int[this.jeu.length][this.jeu.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = this.jeu[i][j].getPlace();
			}
		}
		return temp;
	}

	/**
	 * créer ile avec la mer, les navires,le sable
	 */
	void initialisationIle(){
		int x,y;
		Random r= new Random();
		for(int i = 0; i < taille; i++){
			for(int j = 0; j < taille; j++){
				if(i==0 ||j==0|| i== taille-1 || j == taille-1 ){
					if(i == 0 && j == 1 || i == taille-1 && j == taille-2){
						System.out.println("i : "+i+" - j : "+j);
						this.jeu[i][j] = new Parcelle(5);
					} else
					this.jeu[i][j] = new Parcelle(7);
				}
				else{
					this.jeu[i][j] = new Parcelle(1);
				}
			}
		}
		x=r.nextInt(taille-1)+1;
		y=r.nextInt(taille-1)+1;
		while(x==1 || y==1 || x==taille-2 || y==taille-2 || !estVide(x,y)){
			x=r.nextInt(taille-1)+1;
			y=r.nextInt(taille-1)+1;
		}
		System.out.println("cle: "+x+" "+y);
		this.xcle=x;this.ycle=y;
		this.jeu[x][y]=new Parcelle(9);
		
		x=r.nextInt(taille-1)+1;
		y=r.nextInt(taille-1)+1;
		while(x==1 || y==1 || x==taille-2 || y==taille-2 || !estVide(x,y)){
			x=r.nextInt(taille-1)+1;
			y=r.nextInt(taille-1)+1;
		}
		System.out.println("coffre: "+x+" "+y);
		this.xcoffre=x;this.ycoffre=y;
		this.jeu[x][y]=new Parcelle(10);
		
		this.parcelle2Int();
		this.setJeu();
	}
}