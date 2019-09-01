package collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map;

public class MainCollections {

	public static void main(String[] args) {
		
		
		MapManager mapManager = new MapManager();
		Person paul = new Person("Paul", 25, "1940229054750", "Male");
		mapManager.addMapValues(paul.getCnp(), paul);
		mapManager.printMap();
		Person dan = new Person("Dan", 34, "1940229054750", "Male");
		mapManager.addMapValues(dan.getCnp(), dan);
//		mapManager.printMap();
		paul.setAge(22);
		mapManager.printMap();
		
		
//		=============================================================================================
		
//		
//		SetManager manager = new SetManager();
//		
//		Chocolate chocolateMilkaWhite = new Chocolate("Milka", "White");
//		manager.addChocolate(new Chocolate("Milka", "White"));
//		manager.addChocolate(new Chocolate("Milka", "White"));
//		manager.addChocolate(new Chocolate("Milka", "White"));
//		manager.addChocolate(chocolateMilkaWhite);
//		manager.addChocolate(chocolateMilkaWhite);
//		manager.addChocolate(chocolateMilkaWhite);
//		manager.printChocolateSet();
//		
//		manager.addChocolate(new Chocolate("Heidi", "Black"));
//		manager.printChocolateSet();
		
		
//		List<String> personNames = new Stack<String>();
//		personNames.add("Sebastian");
//		personNames.add("Anca");
//		personNames.add("Vasile");
//		personNames.add("Dacian");
//		personNames.add("Vasile");
//		System.out.println(personNames.size());
//		ListUtils.printList(personNames);
//		personNames.remove("Vasile");
//		ListUtils.printList(personNames);
//		
//		
//		=========================================================================================
		
		
		
	}

}
