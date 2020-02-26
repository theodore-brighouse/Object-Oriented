package mtg;
import java.util.Scanner;

import mtg.cards.CreatureCard;
import mtg.cards.InstantCard;



public class  main{
	public static void main (String[] args) {
		CreatureCard thrun = new CreatureCard("Thrun", "", 4);
		CreatureCard human = new CreatureCard("human", "", 100);
		CreatureCard human2 = new CreatureCard("human", "", 100);
		CreatureCard human3 = new CreatureCard("human", "", 100);
		CreatureCard human4 = new CreatureCard("human", "", 100);

		Deck player1Deck = new Deck(60);
		
		player1Deck.addCard(thrun);
		player1Deck.addCard(human);
		player1Deck.addCard(human2);
		player1Deck.addCard(human3);
		player1Deck.addCard(human4);
		
		// This should print human
		System.out.println(player1Deck.getTopCard().getName());
		player1Deck.drawTopCard();
		player1Deck.drawTopCard();
		player1Deck.drawTopCard();
		player1Deck.drawTopCard();
		// This should print thrun
		player1Deck.getTopCard().play();
		player1Deck.addCard(new InstantCard());
		player1Deck.getTopCard().play();
		
	} 
}