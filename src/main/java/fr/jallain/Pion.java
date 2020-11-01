package fr.jallain;

public class Pion {
	private char symbole;
	private int x;
	private int y;

	public char getSymbole() {
		return symbole;
	}

	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}

	public Pion(char symbole, int x, int y) {
		this.setSymbole(symbole);
		this.x = x;
		this.y = y;
	}
}
