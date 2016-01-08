package uncommentedCode;

import java.util.ArrayList;
import java.util.List;

public class Team {
private Player[] players;

private String teamName;
private int currentPlayer = 0;
private int currentPitcher = 0;
private int score = 0;
private int outs = 0;
private List<Pitcher> listOfPitchers = new ArrayList<Pitcher>();

public Team(Player[] players, String aTeamName){
	this.players = players;
	teamName = aTeamName;
	
	for(Player player : players){
		if(player instanceof Pitcher){
			Pitcher newPitcher = (Pitcher) player;
			listOfPitchers.add(newPitcher);
		}
	}

	if(listOfPitchers.isEmpty()){
		System.out.println("No pitcher found on team " + teamName);
	}
}

public Player getNextPlayer(){
	if(currentPlayer >= players.length){
		currentPlayer = 0;
	}
	
	Player nextPlayer = players[currentPlayer];
	currentPlayer++;
	return nextPlayer;
}

public Pitcher getNextPitcher(){
	if(currentPitcher >= listOfPitchers.size()){
		currentPitcher = 0;
	}
	
	Pitcher nextPitcher = listOfPitchers.get(currentPitcher);
	currentPitcher++;
	return nextPitcher;
}

public void resetOuts(){
	outs = 0;
}

public void addNumberToOuts(int num){
	outs = outs + num;
}

public void addNumberToScore(int num){
	score = score + num;
}

public int getOuts(){
	return outs;
}

public int getScore(){
	return score;
}

public String toString(){
	return teamName + "\nOuts : " + outs + "\nScore : " + score;  
}
}
