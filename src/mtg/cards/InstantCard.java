package mtg.cards;

public class InstantCard implements Card {

	@Override
	public void play() {
		System.out.println("I am an instant!");
		
	}

	@Override
	public void sendToGraveyard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return null;
		
	}
	

}
