package persTrain;

public enum Exercises {

	PUSHUPS(5 , 10),
	BENCHPRESS(10 , 10),
	PULLUPS(15 , 15),
	BACKSQUAT(25 , 25);
	
	private int exStamina;
	private int exStrength;
	
	private Exercises(int exStamina, int exStrength) {
		this.exStrength = exStrength;
		this.exStamina = exStamina;
	}

	public int getExStrength() {
		return exStrength;
	}

	public int getExStamina() {
		return exStamina;
	}
	
}
