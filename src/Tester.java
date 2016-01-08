public class Tester {

public static void main(String[] args){
	Pitcher pitcher = new Pitcher("Pit the Pitcher", 19, 92);
	Pitcher pitcher2 = new Pitcher("Bruce Butter Fingers", 19, 17);
	
	Player[] players = {
			new Player("Fat Frank", 27),
			new Player ("Rocket Jenny", 88),
			pitcher,
			pitcher2
			};
	
	Team someTeam = new Team(players, "The Slugs");
	System.out.println(someTeam + "\n");

	for(int i = 0; i < 5; i++){
		System.out.println("The next Player is \n" + someTeam.getNextPlayer() + "\n");
	}
	
	for(int i = 0; i < 3; i++){
		System.out.println("The next Pitcher is \n" + someTeam.getNextPitcher() + "\n");
	}

	someTeam.addNumberToOuts(2);
	someTeam.addNumberToScore(4);
	System.out.println(someTeam + "\n");
	
	someTeam.resetOuts();
	System.out.println(someTeam);
}
}

