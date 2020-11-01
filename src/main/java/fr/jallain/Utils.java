package fr.jallain;

import java.util.Scanner;

public class Utils {
	static Scanner scanner = new Scanner(System.in);
	static String separator = "___________________________________";

	protected final static void clearConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
}
