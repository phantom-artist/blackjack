package com.phantomartist.blackjack;

public enum CardType {

	// \u1F0A1
	
	ACE("1", 11), // Handle value 1 in game rules
	TWO("2", 2),
	THREE("3", 3),
	FOUR("4", 4),
	FIVE("5", 5),
	SIX("6", 6),
	SEVEN("7", 7),
	EIGHT("8", 8),
	NINE("9", 9),
	TEN("A", 10),
	JACK("B", 10),
	QUEEN("C", 10),
	KING("D", 10);

	private String unicodeSuffix;
	private int value;

	CardType(String unicodeSuffix, int value) {
		this.unicodeSuffix = unicodeSuffix;
		this.value = value;
	}

	public String getUnicodeSuffix() {
		return unicodeSuffix;
	}
	
	public int getValue() {
		return value;
	}
}
