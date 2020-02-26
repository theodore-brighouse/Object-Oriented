package mtg.cards;

public interface Card {
	public void play();
	
	public void sendToGraveyard();
	
	public String getName();
}
