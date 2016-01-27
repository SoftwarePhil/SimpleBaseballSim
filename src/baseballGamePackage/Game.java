package baseballGamePackage;
import java.util.ArrayList;
import java.util.List;

import battingPackage.Batting;
import battingPackage.CurrentBatting;
import teamPackage.CreateTeam;
import teamPackage.Player;
import teamPackage.Team;
import fieldPackage.CurrentField;
import fieldPackage.Field;


public class Game {
	
private CreateTeam ct;
public Team[] teams;
private Batting bat;
private CurrentField cf;
private Field f;

private int amountOfBasesToMove;
private Player currentBattingPlayer;

private int battingTeam;
private int pitchingTeam;
private boolean initOrder;

private int innings;
private int outsToBeAdded;
private List<String> gameEvents = new ArrayList<String>();

private boolean print;
	
public Game(String home, String away, boolean print){
	this.print = print;
	ct = new CreateTeam();
	teams = ct.createTeams(home, away);
	bat = new Batting();
	cf = new CurrentField();
	f = new Field(cf);

	amountOfBasesToMove = 0;
	currentBattingPlayer = null;
	
	battingTeam = 0;
	pitchingTeam = 1;
	initOrder = true;
	
	innings = 1;
}

public void switchTeams(){
	if(initOrder == true){
		battingTeam = 1;
		pitchingTeam = 0;
		initOrder = false;
	}
	else{
		battingTeam = 0;
		pitchingTeam = 1;
		initOrder = true;
	}
}

public void teamAtBat(){
cf.start(teams[pitchingTeam]);
while(teams[battingTeam].getOuts() < 3){
	currentBattingPlayer = teams[battingTeam].getNextPlayer();
	//System.out.println(currentBattingPlayer.getName() + " is at bat");
	gameEvents.add(currentBattingPlayer.getName() + " is at bat");
	CurrentBatting cb = new CurrentBatting(currentBattingPlayer, teams[pitchingTeam].getNextPitcher());
	amountOfBasesToMove = bat.startBatting(cb, print);
	gameEvents.addAll((bat.getGameEvents()));
	
	if(amountOfBasesToMove > 0 ){
		outsToBeAdded = f.newPlayerOnBases(amountOfBasesToMove, currentBattingPlayer, teams[battingTeam].getOuts(), cb.getHomerunOrWalk(), print);
		gameEvents.addAll(f.getGameEvents());
		if(outsToBeAdded > 0){
			teams[battingTeam].addNumberToOuts(outsToBeAdded);
			}
		}
	
	else{
		teams[battingTeam].addNumberToOuts(1);
		System.out.println("OUT HAS HAPPENED " + teams[battingTeam].getOuts());
		gameEvents.add("OUT HAS HAPPENED " + teams[battingTeam].getOuts());
			}
	}
	teams[battingTeam].addNumberToScore(cf.getScore());
	teams[battingTeam].resetOuts();
}

//added the getTeamName method
public void inning(){
	teamAtBat();
	switchTeams();
	//System.out.println("NEW TEAM AT BAT " + teams[battingTeam].getTeamName());
	gameEvents.add("NEW TEAM AT BAT " + teams[battingTeam].getTeamName());
	System.out.println();
	teamAtBat();
	switchTeams();
	//System.out.println("NEW TEAM AT BAT " + teams[battingTeam].getTeamName());
	gameEvents.add("NEW TEAM AT BAT " + teams[battingTeam].getTeamName());
	//System.out.println();
	innings++;
}

public int[] playGame(){
	while(innings < 9){
		inning();
		//System.out.println("score at end of inning " + innings + " is: " +"\n"
		//+"Home Team: "  + teams[0].getTeamName() +" "+ teams[0].getScore() +"\n"+ "Away Team: "  + teams[1].getTeamName() +" "+ teams[1].getScore());
		gameEvents.add("score at end of inning " + innings + " is: " +"\n"
		+"Home Team: "  + teams[0].getTeamName() +" "+ teams[0].getScore() +"\n"+ "Away Team: "  + teams[1].getTeamName() +" "+ teams[1].getScore());
	}
	while(teams[0].getScore() == teams[1].getScore()){
		inning();
		//System.out.println("score at end of inning " + innings + " is: " +"\n"
		//+"Home Team: "  + teams[0].getTeamName() +" "+ teams[0].getScore() +"\n" + "Away Team: " + teams[1].getTeamName() +" " + teams[1].getScore());
		gameEvents.add("score at end of inning " + innings + " is: " +"\n"
				+"Home Team: "  + teams[0].getTeamName() +" "+ teams[0].getScore() +"\n" + "Away Team: " + teams[1].getTeamName() +" " + teams[1].getScore());
	}

	int[] temp = {teams[0].getScore(), teams[1].getScore()};
	
	return temp;
}
public List<String> getGameEvents(){
	return gameEvents;
}
}
