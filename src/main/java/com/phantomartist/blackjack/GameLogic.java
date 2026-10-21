package com.phantomartist.blackjack;

public class GameLogic {

	public static final int TWENTY_ONE = 21;
	public static final int DEALER_STAY = 16;

	public static boolean hasBust(final Player player) {

		final int playerTotal = player.calculateTotal();
		return playerTotal > TWENTY_ONE;
	}

	public static String determineWinner(final Player player, final Player dealer) {

		final int playerTotal = player.calculateTotal();
		final int dealerTotal = dealer.calculateTotal();

		String winner = "PLAYER";
		if ( hasBust(player) || dealerTotal == TWENTY_ONE || (dealerTotal <= TWENTY_ONE && dealerTotal > playerTotal)) {
			winner = "DEALER";
		} else if (dealerTotal == playerTotal) {
			winner = "PUSH";
		}

		return winner;
	}
}