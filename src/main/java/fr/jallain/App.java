package fr.jallain;

/**
 * Hello world!
 */
public final class App {

	private static final void newGame() {
		new Partie();
	}

	public static final void displayMainMenu() {
		Utils.clearConsole();
		System.out.println("_________________________________");
		System.out.println("| x o x o x o x o x o x o x o x |");
		System.out.println("---------------------------------");
		System.out.println("|          * MORPION *          |");
		System.out.println("|    Que voulez-vous faire ?    |");
		System.out.println("---------------------------------");
		System.out.println("|    1) NOUVELLE PARTIE         |");
		System.out.println("|    2) QUITTER                 |");
		System.out.println("L_______________________________I\n");
		System.out.println("#: ");
		String result = Utils.scanner.nextLine();
		if (result.equals("1")) {
			Utils.clearConsole();
			newGame();
		} else if (result.equals("2")) {
			Utils.clearConsole();
			System.exit(0);
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
