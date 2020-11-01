package fr.jallain;

public class Partie {
	Joueur joueurX;
	Joueur joueurO;
	String currentTurn;
	Grille grille;

	public Partie() {
		grille = new Grille();
		joueurX = new Joueur('X');
		joueurO = new Joueur('O');
		System.out.println(grille.getDrawing());
	}
}
