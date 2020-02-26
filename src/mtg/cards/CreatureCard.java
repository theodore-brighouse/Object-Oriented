package mtg.cards;
public class CreatureCard implements PermanentCard{
	private String name;
	private String rulesText;
	private int toughness;
	private int power;
	
	/**
	 * 
	 * @param name the name of the creature card
	 * @param rulesText rules text associated with the card
	 * @param toughness the toughness of the creature
	 */
	public CreatureCard(String name, String rulesText, int toughness) {
		this.name = name;
		this.rulesText = rulesText;
		this.toughness = toughness;
		this.power = power;
	}
	
	public void tap() {
		
	}
	
	public void block(int damage) {
		toughness = toughness - power;
	}
	
	public int getToughness() {
		return toughness;
	}
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		System.out.println("Hi I am a creature card");
		
	}

	@Override
	public void sendToGraveyard() {
		// TODO Auto-generated method stub
		
	}
}
