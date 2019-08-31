package persTrain;
import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;


public class PersonalTrainerMain {
	
	private static Trainer trainer ;
	private static Trainee trainee;
	private static int stamina;
	private static int strength;
	private static Supliments supliments;
	private static int staminaSupliments;
	private static int strengthSupliments;
	public static void main(String[] args) {
		
		
		trainer = new Trainer("Dan", 100 , 0);
		trainee = new Trainee("Paul", 100, 0);
		supliments = new Supliments(50, 25);
		staminaSupliments = supliments.getStamina();
		strengthSupliments = supliments.getStrength();
		System.out.println(staminaSupliments + " " + strengthSupliments);
		stamina = trainee.getStamina();
		strength = trainee.getStrength();
		
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Hello, my name is %s. I'll be your personal trainer !\n", trainer.getName());
		warmUp(scanner);
		training();
		
		
}
	
	private static void training() {
		Scanner scanner = new Scanner(System.in);
		while(stamina > 0 ){
		System.out.println("\nCurrent stamina is : " + stamina +"\tCurrent strength is : "+ strength);
		chooseAExercise(scanner);
		scanner.nextLine();
		
		}
		System.out.println("You are out of stamina or you pushed too for today !\nInput 'yes' if you want some supliment so you keep training, or input 'quit' to exit !!");
		shouldContinue(scanner);
		supliments();
		training();
		}
	
	
	
	
	private static void supliments() {
		
		if(stamina < 0) {
			stamina = stamina +  staminaSupliments;
			strength = strength - strengthSupliments;
		}
	}
	
	
	
	private static void totalStaminaAndStrength(String exercise) {
		switch(exercise) {
		case "PUSHUPS":
			 stamina -= Exercises.PUSHUPS.getExStamina();
			 strength += Exercises.PUSHUPS.getExStrength();
		break;
		case "BENCHPRESS":
			stamina -= Exercises.BENCHPRESS.getExStamina();
			strength += Exercises.BENCHPRESS.getExStrength();
		break;
		case "PULLUPS":
			stamina -= Exercises.PULLUPS.getExStamina();
			strength += Exercises.PULLUPS.getExStrength();
		break;
		case "BACKSQUAT":
			stamina -= Exercises.BACKSQUAT.getExStamina();
			strength += Exercises.BACKSQUAT.getExStrength();
		break;
		
		default: System.out.println("You can not do that !");
		}
		
	}
	
	private static void warmUp(Scanner scanner) {
		System.out.println("You need to warm up first - to warm up write 'Yes' to exit gym write 'quit' !");
		shouldContinue(scanner);
		int warming = 1;
		for(int i = 0; i < warming; i++) {
			warmUpStamina();
		}
		System.out.println("\nGreat you've warm up , now you can continue with more exercises!");
			}
	private static void warmUpStamina() {
		
		stamina = trainee.getStamina() - 10;
		strength = trainee.getStrength() + 10;
		System.out.printf("\nAfter warming, your stamina is at %d and your strength at %d", stamina, strength);
	}
	
	private static void chooseAExercise(Scanner scanner) {
		
		System.out.printf("\nChoose one of the following exercises: %s" , Arrays.toString(Exercises.values()));
		getRandomExercise();
		
	}
	

	private static void getRandomExercise() {
		Random random = new Random();
		int index = random.nextInt(4);
		Exercises exerList = Exercises.values()[index];
		System.out.println("\nYou've choosen: " + exerList.name());
		totalStaminaAndStrength(exerList.name());
	}
	
	
	
	private static boolean shouldContinue(Scanner scanner) {
		String decision = scanner.nextLine();
		if(decision.equalsIgnoreCase("yes")) {
			return true;
		}else if(decision.equalsIgnoreCase("quit")) {
			System.out.println("Have a great day !");
			return false;
		}else {
			System.out.println("Please enter 'yes' or 'quit': ");
			return shouldContinue(scanner);
			
		}
	} 	
	
}
