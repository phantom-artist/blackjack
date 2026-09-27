package com.phantomartist.blackjack;

import java.util.Scanner;

public class Output {

	public static void print(final Record record) {
		if (record != null) {
			print(record.toString());
		}
	}

	public static void print(final Object object) {
		if (object != null) {
			print(object.toString());
		}
	}

	public static void print(final String toPrint) {
		System.out.println(toPrint);
	}

	public static String ask(final String question) {
		print(question + "\r\n");
		try (Scanner sc = new Scanner(System.in, System.getProperty("stdin.encoding"))) {
			while (sc.hasNextLine()) {
				return sc.nextLine();
			}
		}
		return null;
	}
}
