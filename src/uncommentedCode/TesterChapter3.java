package uncommentedCode;
public class TesterChapter3 {

public static void main(String[] args){
	
	//here we are making two Pitcher objects
	Pitcher pitcher = new Pitcher("Pit the Pitcher", 19, 92);
	Pitcher pitcher2 = new Pitcher("Bruce Butter Fingers", 19, 17);
	
	//here we are constructing a players array
		//notice we are just putting the each element into the array
		//we can both construct new objects inside here or put ones
		//that have already been made
	Player[] players = {
			new Player("Fat Frank", 27),
			new Player ("Rocket Jenny", 88),
			pitcher,
			pitcher2
			};
	
	//here we are making a reference variable called someTeam
	//and storing a Team object that takes are Players array
		//and the String "The Slugs" as parameters for its constructor
	//notice how this new Team object is made up of Player objects
	Team someTeam = new Team(players, "The Slugs");
	
	//this prints our team, testing our toString() method
	//"\n" is used to make a new line, making our output look better
	System.out.println(someTeam + "\n");
	
	//this for loop is testing the getNextPlayer() method
		//the last player it prints should be the same as the first
		//there are only 4 players on this team
	for(int i = 0; i < 5; i++){
		System.out.println("The next Player is \n" + someTeam.getNextPlayer() + "\n");
	}
	
	//this for loop is testing the getNextPitcher() method
			//the last pitcher it prints should be the same as the first
			//there are only 2 pitchers on this team
	for(int i = 0; i < 3; i++){
		System.out.println("The next Pitcher is \n" + someTeam.getNextPitcher() + "\n");
	}
	
	//after running these we expect the number of outs to be 2
		//and the score to be 4
	someTeam.addNumberToOuts(2);
	someTeam.addNumberToScore(4);
	
	System.out.println(someTeam + "\n");
	
	//outs should equal 0 now
	someTeam.resetOuts();
	
	System.out.println(someTeam);
}
}

