package uncommentedCode;
public class Tester {

public static void main(String[] args){
	
	Player bob = new Player("Bob Smith", 44);
	Player steve = new Player("Steve Harris", 54);
	
	String steveName = steve.getName();
	System.out.println("Player name is " + steveName);
	
	int steveBatting = steve.getBattingStrength();
	System.out.println("Player batting strength is " + steveBatting);	
}
}
