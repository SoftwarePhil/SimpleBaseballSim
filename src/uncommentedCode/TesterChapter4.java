package uncommentedCode;
public class TesterChapter4 {

public static void main(String[] args){

	//this makes a Player array with the following Players
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
	
	//this makes a Team, using the above Player array
	Team teamOne = new Team(players, "The Slugs");
	Team teamTwo = new Team(players2, "The Snails");
	
	//this simulates a Team being up at bat
		//all 4 of the teams players are cycled through
	for(int i = 0; i < 4; i++){
		System.out.println("_____________________________________");
		Batting batting = new Batting();
		Player tempPlayer =  teamOne.getNextPlayer();
		Pitcher tempPitcher = teamTwo.getNextPitcher();
		
		System.out.println("Player at bat : " + tempPlayer.getName());
		System.out.println("Pitcher pitching : " + tempPitcher.getName());
		
		CurrentBatting cb = new CurrentBatting(tempPlayer, tempPitcher);
		int numberOfBases = batting.startBatting(cb, true);
		
		System.out.println(batting + "\nThey will move " + 
							numberOfBases + " base(s)");
	}
	
	//the following lines of code test if Batting is working
		//correctly, we use a for loop to run 1000 tests
	int amountOfTests = 1000;
	System.out.println("\nA large test ~~ total should be "
						+ 99 * amountOfTests);
	
	Player maxPlayer = new Player("pyMax", 100);
	Pitcher maxPitcher = new Pitcher("pMax", 0, 100); 
	
	Batting b = new Batting();
	int[] numbers = new int[amountOfTests * 4];
	
	//this for loop takes the integers from the Batting toString()
	//and looks for numbers that are less then 0 and greater than 99
	//it also sums the total amount of numbers to make sure
		//each time generateRates runs the total exactly 99
	for(int i = 0; i < amountOfTests; i++){
		CurrentBatting maxCB = new CurrentBatting(maxPlayer, maxPitcher);
		b.startBatting(maxCB, false);
		//gets the toString from Batting
		String data = b.toString();
		
		String tempString;
		String[] values = new String[4];
		
		//puts the chanceOfBall into an array at position 0
		//we are removing the "Chance of Ball " from the first line
		tempString = data.replaceAll("Chance of ball: ", "");
		
		//we are spitting the String every time there is a new line
		values[0] = tempString.split("\n", 0)[0];
		
		tempString = data.replaceAll("Chance of hit: ", "");
		values[1] = tempString.split("\n", 0)[1];
		
		tempString = data.replaceAll("Chance of foul: ", "");
		values[2] = tempString.split("\n", 0)[2];
		
		tempString = data.replaceAll("Chance of strike: ", "");
		values[3] = tempString.split("\n", 0)[3];
		
		int sum = 0;
		
		//here we are putting our array of Strings which just
			//contains an integer into a larger integer array
		for(int j = 0; j < 4; j++){
			int currentIndex = j + (i*4);
			//parseInt converts a String into an int
			numbers[currentIndex] = Integer.parseInt(values[j]);
			sum = sum + numbers[currentIndex];
		}
		
		//this checks to make sure each Batting equals 99
		if(!(sum == 99)){
			System.out.println(b);
			System.out.println("TEST FAIL " + sum);
		}
	}
	
	int total = 0;
	//this makes sure no single value is less than 0
		//or greater than 100
	for(int i : numbers){
		total = total + i;
		if(i < 0){
			System.out.println(i + " number less than 0");
			System.out.println(b);
		}
		
		if(i > 99){
			System.out.println(i + " number greater than 100");
			System.out.println(b);
		}
	}
	
	//we expect a value of 99,000
	System.out.println("the total is " + total);
}
}

