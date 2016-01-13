public class Tester {

public static void main(String[] args){

	Player[] players = {
			new Player("Fat Frank", 27),
			new Player ("Rocket Jenny", 88),
			new Pitcher("Bruce Butter Fingers", 19, 17),
			new Pitcher("Pit the Pitcher", 31, 92)
			};
	
	Player[] players2 = {
			new Player("Fancy Frank", 44),
			new Player ("Jenny", 66),
			new Pitcher("Barry Big Hands", 15, 50),
			new Pitcher("Timbo Tim", 19, 70)
			};
	
	Team teamOne = new Team(players, "The Slugs");
	Team teamTwo = new Team(players2, "The Snails");
	
	Batting batting = new Batting();
	CurrentBatting cb = new CurrentBatting(teamOne.getNextPlayer(), 
							teamTwo.getNextPitcher());
	
	int numberOfBases = batting.startBatting(cb);
	
	System.out.println("\n"+batting + "\nThey will move " + 
						numberOfBases + " base(s)");
}
}

