package collections;
import java.util.HashMap;
import java.util.Map;

public class MapManager {

	private Map<String , Person> myMap = new HashMap<String, Person>(); 
	
	public void printMap() {
		System.out.println(myMap);
	}
	
	public void addMapValues(String key, Person value) {
		myMap.put(key, value);
		}
	
	public void removeMapValues(String key, Person value) {
		myMap.remove(key, value);
	}
	
	public void replaceMapValues(String key, Person value) {
		myMap.replace(key, value);
	}
}
