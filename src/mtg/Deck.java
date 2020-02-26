package mtg;
import mtg.cards.Card;

public class Deck {
	private Card[] deck;
	
	public Deck(int deckSize) {
		deck = new Card[deckSize];
	}
	
	public void addCard (Card card) {
		if (deck[deck.length-1] == null) {
			for (int i = deck.length-1; i >= 1; i--) {
				deck[i] = deck[i-1];
			}
			deck[0] = card;
		}else System.out.println("deck is full");	
	}	
	
	public Card getTopCard () { 
		Card topCard = deck[0];
		return topCard;
	}
	public void drawTopCard () {	
		for (int i = 0; i < deck.length-1; i++) {
			deck[i] = deck[i+1];
		}
		deck[deck.length-1] = null;
	}
}
 