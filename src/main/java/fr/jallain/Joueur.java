package fr.jallain;

public class Joueur {
	char symbole;

	public Joueur(char symbole) {
		this.symbole = symbole;
	}

	protected boolean play(Grille grille, int x, int y) {
		return grille.setValeur(x, y, this.symbole);
	}

}
