package fr.jallain;

import java.util.Arrays;
import java.util.List;

public class Partie {
	protected Joueur joueurX;
	protected Joueur joueurO;
	protected Joueur currentPlayer;
	Grille grille;

	public Partie() {
		init();
	}

	private void init() {
		grille = new Grille();
		joueurX = new Joueur('X');
		joueurO = new Joueur('O');
		currentPlayer = getRandomFirstPlayer();
		newTurn();
	}

	protected Joueur getRandomFirstPlayer() {
		int r = (int) (Math.random() * 2);
		if (r == 0) {
			return joueurO;
		} else {
			return joueurX;
		}
	}

	private void newTurn() {
		if (isWon() != null) {
			WinCondition win = isWon();
			System.out.println("Le joueur " + win.symbol + " a gagné sur la " + win.endroit + " !");
			printEnd();
		} else if (grille.isFull()) {
			System.out.println("La grille est pleine ! Pas de gagnants..");
			printEnd();

		} else {
			Utils.clearConsole();
			displayNewTurn();
		}
	}

	private void printEnd() {
		System.out.println("Appuyez sur entrée pour revenir au menu..");
		Utils.scanner.nextLine();
		Utils.clearConsole();
		App.displayMainMenu();
	}

	private void displayNewTurn() {
		System.out.println(grille.getDrawing());
		askToPlay();
	}

	private void askToPlay() {
		System.out.println("Joueur " + currentPlayer.symbole + ", où voulez-vous jouer ?");

		System.out.println("Coordonnée x:");
		String inputX = Utils.scanner.nextLine();
		if (!checkCoordsInput(inputX))
			sayNonValidCoord();

		System.out.println("Coordonnée y:");
		String inputY = Utils.scanner.nextLine();
		if (!checkCoordsInput(inputY))
			sayNonValidCoord();

		int x = Integer.parseInt(inputX);
		int y = Integer.parseInt(inputY);

		boolean couldPlay = currentPlayer.play(grille, x, y);
		if (couldPlay) {
			switchPlayers();
			newTurn();
		} else {
			System.out.println("Il y a déjà un pion à cet emplacement !");
			askToPlay();
		}
	}

	private void sayNonValidCoord() {
		System.out.println("Coordonnée non valide ! Entrez un chiffre entre 0 et 2.");
		askToPlay();
	}

	private void switchPlayers() {
		currentPlayer = currentPlayer.symbole == 'X' ? joueurO : joueurX;
	}

	private boolean checkCoordsInput(String input) {
		try {
			int test = Integer.parseInt(input);
			return test >= 0 && test <= 2;
		} catch (Exception e) {
			return false;
		}
	}

	private WinCondition isWon() {
		char c00 = grille.getSymbol(0, 0);
		char c10 = grille.getSymbol(1, 0);
		char c20 = grille.getSymbol(2, 0);
		char c01 = grille.getSymbol(0, 1);
		char c11 = grille.getSymbol(1, 1);
		char c21 = grille.getSymbol(2, 1);
		char c02 = grille.getSymbol(0, 2);
		char c12 = grille.getSymbol(1, 2);
		char c22 = grille.getSymbol(2, 2);
		boolean line1Condition = c00 != ' ' && c00 == c10 && c10 == c20;
		boolean line2Condition = c01 != ' ' && c01 == c11 && c11 == c21;
		boolean line3Condition = c02 != ' ' && c02 == c12 && c12 == c22;
		WinCondition line1 = new WinCondition(line1Condition, "première ligne", c00);
		WinCondition line2 = new WinCondition(line2Condition, "seconde ligne", c01);
		WinCondition line3 = new WinCondition(line3Condition, "troisième ligne", c02);

		boolean col1Condition = c00 != ' ' && c00 == c01 && c01 == c02;
		boolean col2Condition = c10 != ' ' && c10 == c11 && c11 == c12;
		boolean col3Condition = c20 != ' ' && c20 == c21 && c21 == c22;
		WinCondition col1 = new WinCondition(col1Condition, "première colonne", c00);
		WinCondition col2 = new WinCondition(col2Condition, "seconde colonne", c10);
		WinCondition col3 = new WinCondition(col3Condition, "troisième colonne", c20);

		boolean diag1Condition = c00 != ' ' && c00 == c11 && c11 == c22;
		boolean diag2Condition = c20 != ' ' && c20 == c11 && c11 == c02;
		WinCondition diag1 = new WinCondition(diag1Condition, "diagonale 1", c00);
		WinCondition diag2 = new WinCondition(diag2Condition, "diagonale 2", c20);

		List<WinCondition> conditions = Arrays.asList(line1, line2, line3, col1, col2, col3, diag1, diag2);
		for (WinCondition winCondition : conditions) {
			if (winCondition.condition == true)
				return winCondition;
		}

		return null;

	}
}
