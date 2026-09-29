package com.phantomartist.blackjack;

public enum Suit {

	SPADE("A"),
	HEART("B"),
	DIAMOND("C"),
	CLUB("D");

	private String unicode;
	Suit(String unicode) {
		this.unicode = unicode;
	}

	public String getUnicode() {
		return unicode;
	}
}
