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

	public void setValeur(int x, int y, char symbol) {
		if (getValeur(x, y) == null) {
			Pion pion = new Pion(symbol, x, y);
			this.valeurs[x][y] = pion;
		} else {
			System.out.println("Deja un pion ici");
		}
	}

	public String getDrawing() {
		String separator = "---|---|---\n";
		String line1 = " " + this.getSymbol(0, 0) + " | " + this.getSymbol(1, 0) + " | " + this.getSymbol(2, 0) + "\n";
		String line3 = " " + this.getSymbol(0, 1) + " | " + this.getSymbol(1, 1) + " | " + this.getSymbol(2, 1) + "\n";
		String line5 = " " + this.getSymbol(0, 2) + " | " + this.getSymbol(1, 2) + " | " + this.getSymbol(2, 2);
		String result = line1 + separator + line3 + separator + line5;
		return result;
	}
}
