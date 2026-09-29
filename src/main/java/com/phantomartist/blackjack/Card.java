package com.phantomartist.blackjack;

public record Card(Suit suit, CardType type) { 
	
	public String toShortString() {
		return "[" + type.name() + " of " + suit.name() + "S]";
	}

	/**
	 * https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
	 * 
	 * @return String the unicodeCharacter
	 */
	public String toUnicodeCharacter() {

		String hexCodePoint = "1F0"+suit().getUnicode()+type.getUnicodeSuffix(); // Hexadecimal representation
		int codePoint = Integer.parseInt(hexCodePoint, 16); // Convert to integer
		char[] chars = Character.toChars(codePoint); // Get character array
		String unicodeCharacter = String.valueOf(chars); // Convert to string
		return unicodeCharacter;
	}
}