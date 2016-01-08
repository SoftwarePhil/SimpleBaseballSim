//these imports are needed to use the ArrayList class	
import java.util.ArrayList;
import java.util.List;

public class Team {

//declares an instance variable called players of type Player array
private Player[] players;

private String teamName;
private int currentPlayer = 0;
private int currentPitcher = 0;

//this will be used to keep track of the number of runs the team has scored
private int score = 0;

//this will be used to keep track of the number of outs a team has accumulated 
private int outs = 0;

//here we are creating an ArrayList of type Pitcher(note how we used <> with Pitcher inside)
	//<Pitcher> makes the ArrayList able to store Pitcher objects
private List<Pitcher> listOfPitchers = new ArrayList<Pitcher>();

//this the constructor for Team
//it takes an array of Players and a String as parameters  
public Team(Player[] players, String aTeamName){
	
	//note both variables called players, but one has a "this."
		//this means that we are talking about the instance variable
		//players on the left side is the method parameter  
	this.players = players;
	teamName = aTeamName;
	
	//here we are using a special kind of for loop called a for each loop
		//first we define a variable of the type that makes up our list or array
		//next we put a colon
		//and finally we specify the array or list we want to use
		//this is easier to construct then using a standard for loop 
			//for cycling through arrays
	for(Player player : players){
		//this if statement checks to see if the object is a Pitcher
		if(player instanceof Pitcher){
			//if the object is a Pitcher we store him in a new variable called newPitcher
				//note the (Pitcher), here we are casting the Player object as Pitcher
				//this is like how we took a decimal number and casted it as an int
			Pitcher newPitcher = (Pitcher) player;
			
			//here we are adding newPitcher to our ArrayList
			listOfPitchers.add(newPitcher);
		}
	}
	
	//this if statement is checking to see if the newly created Team has a Pitcher
		//if the Team object has no Pitcher object it will cause problems for
			//our simulation 
	if(listOfPitchers.isEmpty()){
		//this println will let us know something went wrong
		System.out.println("No pitcher found on team " + teamName);
	}
	
}

//this method will return the next Player who is up at bat
public Player getNextPlayer(){
	
	//this if statement checks to make sure our array does not go out of bounds
	if(currentPlayer >= players.length){
		//if we are >= the length of the array set currentPlayer back to 0
		currentPlayer = 0;
	}
	
	//this is the next Player that the will bat
	Player nextPlayer = players[currentPlayer];
	//this increases the value of currentPlayer by 1
	//next time this method is called the next Player in the array will be returned
	currentPlayer++;
	return nextPlayer;
}

//this method returns the next Pitcher who will pitch the ball
//it works the same as getNextPlayer except that it used an
	//ArrayList and returns a Pitcher object
public Pitcher getNextPitcher(){
	if(currentPitcher >= listOfPitchers.size()){
		currentPitcher = 0;
	}
	
	Pitcher nextPitcher = listOfPitchers.get(currentPitcher);
	currentPitcher++;
	return nextPitcher;
}

//this method will reset outs to 0
public void resetOuts(){
	outs = 0;
}

//this method will add a number to the current amount of outs
public void addNumberToOuts(int num){
	outs = outs + num;
}

//this method will add a number to the current score
public void addNumberToScore(int num){
	score = score + num;
}

//this method will return the current amount of outs
public int getOuts(){
	return outs;
}

//this method will return the current score
public int getScore(){
	return score;
}

//this bracket ends the Team class
}
