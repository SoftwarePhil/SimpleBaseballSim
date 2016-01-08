//we are making a new class called tester
public class Tester {

//all Java programs need a main method, this is how we declare a main method
public static void main(String[] args){

	Player[] p = {new Player("bob", 55), new Pitcher("pit", 55, 66), new Pitcher("pit2", 55, 36)};
	
	Team t = new Team(p, "myTeam");
	
	System.out.println(t.getNextPitcher() + "\n" + t.getNextPitcher() +"\n" + t.getNextPitcher() +"\n" + t.getNextPitcher());
//this ends our main method
}

//this ends our tester class
}
