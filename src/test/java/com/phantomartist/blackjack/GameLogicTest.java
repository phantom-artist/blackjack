package com.phantomartist.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GameLogicTest {

	@Test
	void testPlayerWin() {

		Player player = new Player(
				new Card(Suit.CLUB, CardType.ACE),
				new Card(Suit.CLUB, CardType.KING));
		
		Player dealer = new Player(
				new Card(Suit.CLUB, CardType.EIGHT),
				new Card(Suit.CLUB, CardType.TEN));

		assertEquals("PLAYER", GameLogic.determineWinner(player, dealer));
	}

	@Test
	void testPlayerBust() {

		Player player = new Player(
				new Card(Suit.CLUB, CardType.QUEEN),
				new Card(Suit.CLUB, CardType.KING));
		
		final List<Card> nextCards = new ArrayList<>();
		nextCards.add(new Card(Suit.CLUB, CardType.TEN));
		player.drawNextCard(nextCards);

		Player dealer = new Player(
				new Card(Suit.CLUB, CardType.EIGHT),
				new Card(Suit.CLUB, CardType.TEN));

		assertEquals("DEALER", GameLogic.determineWinner(player, dealer));
	}

	@Test
	void testDealerWin() {

		Player player = new Player(
				new Card(Suit.CLUB, CardType.JACK),
				new Card(Suit.CLUB, CardType.EIGHT));
		
		Player dealer = new Player(
				new Card(Suit.CLUB, CardType.ACE),
				new Card(Suit.CLUB, CardType.TEN));

		assertEquals("DEALER", GameLogic.determineWinner(player, dealer));
	}

	@Test
	void testPush() {
		
		Player player = new Player(
				new Card(Suit.CLUB, CardType.JACK),
				new Card(Suit.CLUB, CardType.EIGHT));
		
		Player dealer = new Player(
				new Card(Suit.SPADE, CardType.TEN),
				new Card(Suit.HEART, CardType.EIGHT));

		assertEquals("PUSH", GameLogic.determineWinner(player, dealer));
	}

	@Test
	void testAceAsOne() {

		Player player = new Player(
				new Card(Suit.CLUB, CardType.ACE),
				new Card(Suit.HEART, CardType.ACE));

		final List<Card> nextCards = new ArrayList<>();
		nextCards.add(new Card(Suit.CLUB, CardType.TEN));
		nextCards.add(new Card(Suit.DIAMOND, CardType.NINE));

		player.drawNextCard(nextCards);
		player.drawNextCard(nextCards);

		Player dealer = new Player(
				new Card(Suit.CLUB, CardType.QUEEN),
				new Card(Suit.CLUB, CardType.TEN));

		assertEquals("PLAYER", GameLogic.determineWinner(player, dealer));
	}
}
