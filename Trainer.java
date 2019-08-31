package persTrain;

public class Trainer {

	private String name;
		private int stamina;
		private int strength;
		
		public Trainer(String name, int stamina, int strength) {
			this.name = name;
			this.stamina = stamina;
			this.strength = strength;		
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public int getStamina() {
			return stamina;
		}
	
		public void setStamina(int stamina) {
			this.stamina = stamina;
		}
	
		public int getStrength() {
			return strength;
		}
	
		public void setStrength(int strength) {
			this.strength = strength;
		}
	
	

}
