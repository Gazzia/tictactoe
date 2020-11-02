package fr.jallain;

public class Grille {
	private Pion[][] valeurs;

	public Grille() {
		valeurs = new Pion[3][3];
	}

	public Pion getValeur(int x, int y) {
		return valeurs[x][y];
	}

	public char getSymbol(int x, int y) {
		Pion pion = this.getValeur(x, y);
		if (pion != null)
			return pion.getSymbole();
		else
			return ' ';
	}

	public boolean setValeur(int x, int y, char symbol) {
		if (getValeur(x, y) == null) {
			Pion pion = new Pion(symbol, x, y);
			valeurs[x][y] = pion;
			return true;
		} else {
			// Deja un pion ici
			return false;
		}

	}

	public boolean isFull() {
		int total = 0;
		for (Pion[] ligne : valeurs) {
			for (Pion pion : ligne) {
				if (pion != null)
					total++;
			}
		}
		return total == 9;
	}

	public String getDrawing() {
		String margin = "    ";
		String subMargin = "   ";
		String separator = margin + "  ---|---|---\n";

		String line0 = margin + "x: 0   1   2   y\n\n";
		String line1 = margin + subMargin + this.getSymbol(0, 0) + " | " + this.getSymbol(1, 0) + " | "
				+ this.getSymbol(2, 0) + subMargin + "0\n";
		String line3 = margin + subMargin + this.getSymbol(0, 1) + " | " + this.getSymbol(1, 1) + " | "
				+ this.getSymbol(2, 1) + subMargin + "1\n";
		String line5 = margin + subMargin + this.getSymbol(0, 2) + " | " + this.getSymbol(1, 2) + " | "
				+ this.getSymbol(2, 2) + subMargin + "2";

		String result = line0 + line1 + separator + line3 + separator + line5 + "\n";

		return result;
	}

}
