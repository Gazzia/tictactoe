package fr.jallain;

/**
 * Hello world!
 */
public final class App {

	private static final void newGame() {
		new Partie();
	}

	private static final void displayMainMenu() {
		Utils.clearConsole();
		System.out.println("---------------------------");
		System.out.println("## PENDU - Menu Principal");
		System.out.println("Que voulez-vous faire ?\n");
		System.out.println("1) Nouvelle partie");
		System.out.println("2) Quitter");
		System.out.println("Choix: ");
		String result = Utils.scanner.nextLine();
		if (result.equals("1")) {
			Utils.clearConsole();
			newGame();
		} else {
			Utils.clearConsole();
			System.out.println("Je n'ai pas compris la commande..");
			displayMainMenu();
		}

	}

	public static void main(String[] args) {
		displayMainMenu();
	}
}
