package fieldPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import teamPackage.Player;

public class Field {

private CurrentField currentField;
private int[] temp;
private int currentAmountOfOuts = 0;
private List<String> outputList = new ArrayList<String>();

public Field(CurrentField cf){
	currentField = cf;
}

public int newPlayerOnBases(int n, Player p, int numOfOuts, String walkOrHomeRun, boolean print){
	outputList.clear();
	currentAmountOfOuts = numOfOuts;
	if(walkOrHomeRun.equals("walk")){
		newPlayerOnBasesWalk(p);
	}
	
	else if(walkOrHomeRun.equals("homerun")){
		newPlayerOnBasesHomerun(p);
	}
	
	else{
		currentField.putBallIntoRandomSquare();
		if(!(checkIfBallIsCaught())){
			try{
			System.out.println("amount of bases to move " + n);
			addStringToOutput("amount of bases to move " + n);
			
			
			if (n > 0){	
				if(!(currentField.three.getPlayerOnBase() == null)){
					playerOnThrid();
				}
				
				if(!(currentField.two.getPlayerOnBase() == null)){
					currentField.two.movePlayerToNextBase();
					if(isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3))){
						if(n >= 2){
							playerOnThrid();
							}
						}
				}
				
				if(!(currentField.one.getPlayerOnBase() == null)){
					switch (n){
						case 1: {
							currentField.one.movePlayerToNextBase();
							
							if(isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2))){
								moveOneBase(p);
							}
							break;
						}
						
						case 2: {
							currentField.one.movePlayerToNextBase();
							if(isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2))){
								currentField.two.movePlayerToNextBase();
							
								if(isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3))){
									moveTwoBases(p);
								}
							}
							break;
						}
						
						case 3: {
							currentField.one.movePlayerToNextBase();
							if(isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2))){
								currentField.two.movePlayerToNextBase();
								
								if(isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3))){
									playerOnThrid();
									movePlayerThreeBases(p);
								break;
								}
							}
						}
					}
				}
				else {
					switch(n){
					case 1: {
						moveOneBase(p);
						break;
					}
					case 2: {
						moveTwoBases(p);
						break;
					}
					case 3: {
						movePlayerThreeBases(p);
						break;
					}
					}
				};
			}
		}
		catch(Exception e){
			//System.out.println("three outs have happened! ending fielding");
			addStringToOutput("three outs have happened! ending fielding");
			}
		}
	
		else {
				currentField.addOneToOuts();
			}
	
	}
	if(print){
		printOutputList();
	}
	return currentField.getOuts();
}

private void moveOneBase(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
}

private void moveTwoBases(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	boolean b = isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
		
	if(!b){
		currentField.one.movePlayerToNextBase();
		isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
		}
}

private void movePlayerThreeBases(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	boolean b = isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
	
	if(!b){
		currentField.one.movePlayerToNextBase();
		b = isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
		}
	
	if(!b){
		currentField.two.movePlayerToNextBase();
		isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
	}
}

private boolean checkIfBallIsCaught(){
	//gridFieldArray[0][0].setKey("LF", 15);
	//gridFieldArray[0][2].setKey("CF", 15);
	//gridFieldArray[0][4].setKey("RF", 15);
	temp = currentField.ball.getPostion(); 
	//System.out.println("Ball hit into field at " + " Ball pos " + temp[0] +" :" + temp[1]);
	addStringToOutput("Ball hit into field at " + " Ball pos " + temp[0] +" :" + temp[1]);

	if((temp[0] == 0 && temp[1] == 0) || (temp[0] == 0 && temp[1] == 2) || (temp[0] == 0 && temp[1] == 4)){
		//System.out.println("...checking if ball was caught");
		return isBallCaught(temp[0], temp[1]);
	}
	else return false;
}

private boolean isBallCaught(int x, int y){
	boolean bool = currentField.wasBallCaught(x, y);
	if(bool){
		addStringToOutput("Ball has been caught OUT!");
	}
	return bool;
}

private boolean checkIfPlayerIsOnSameBaseAsBall(int baseNum){
	/*
	int rand = (int)(Math.random()*100);
	if(rand > 60){
		return true;
	}
	else return false;
	*/
	currentField.putBallIntoRandomInFieldSquare();
	
	int[] basePos = new int[2];
	switch (baseNum){
	case 1:{
		basePos[0] = 3;
		basePos[1] = 4;
		break;
	}
	case 2:{
		basePos[0] = 2;
		basePos[1] = 3;
		break;
	}
	case 3:{
		basePos[0] = 3;
		basePos[1] = 0;
		break;
	}
	case 4:{
		basePos[0] = 3;
		basePos[1] = 2;
		break;
	}
	}
	temp = currentField.ball.getPostion(); 
	//System.out.println("Base num " + basePos[0] +" : "+ basePos[1] + " Ball pos " + temp[0] +" :" + temp[1]);
	if(temp[0] == basePos[0] && temp[1] == basePos[1] ){
		//System.out.println("Ball and player are on same base");
		addStringToOutput("Ball and player are on same base");
		return isBallCaught(temp[0], temp[1]);
	}
	
	return false;
}

private boolean isPlayerOutOnBase(int baseNum, boolean b) throws Exception{
try{
	if(currentAmountOfOuts + currentField.getOuts() >= 3){
		throw new Exception("3 outs have happened");
	}

	if((b)){
	//System.out.println("Player may get out on base");
	switch (baseNum){
		case 1: {
				currentField.addOneToOuts();
				//System.out.println("Player got out on 1st base!");
				addStringToOutput("Player got out on 1st base!");
				currentField.one.removePlayerOnBase();
				return true;
			}
		case 2: {
				currentField.addOneToOuts();
				//System.out.println("Player got out on 2nd base!");
				addStringToOutput("Player got out on 2nd base!");
				currentField.two.removePlayerOnBase();
				return true;
			}
		case 3: {
				currentField.addOneToOuts();
				//System.out.println("Player got out on 3rd base!");
				addStringToOutput("Player got out on 3rd base!");
				currentField.three.removePlayerOnBase();
				return true;

		}
		case 4: {
				currentField.addOneToOuts();
				//System.out.println("Player got out on home plate!");
				addStringToOutput("Player got out on home plate!");
			return true;
		}
		default: {
			System.out.println("SOMETHING WENT WRONG");
		}
	}
	}
	//System.out.println("Player made it to base safely!");
	addStringToOutput("Player made it to base safely!");
	return false;
	}
		finally{
		}
}

private void playerOnThrid(){
	if(currentField.three.getPlayerOnBase() == null){
	}
	else{
		try{
			boolean test = isPlayerOutOnBase(4, checkIfPlayerIsOnSameBaseAsBall(4));
			
			if(!test){
			currentField.three.movePlayerToNextBase();
			currentField.addScore();
			//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
			addStringToOutput(currentField.home.getPlayerOnBase() + " has scored");
				}
			}
			catch(Exception e){
				//System.out.println("3 outs have happened on the field");
				addStringToOutput("3 outs have happened on the field");
			}
	}
}

private void newPlayerOnBasesWalk(Player p){	
	//System.out.println("amount of bases to move is 1, walk ");
	if(!(currentField.three.getPlayerOnBase() == null)){
		if(currentField.three.getPlayerOnBase() == null){
		}
		else{
			currentField.three.movePlayerToNextBase();
			currentField.addScore();
			//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
			addStringToOutput(currentField.home.getPlayerOnBase() + " has scored"); 
			}
		}
	if(!(currentField.two.getPlayerOnBase() == null)){
		currentField.two.movePlayerToNextBase();
	}
	
	if(!(currentField.one.getPlayerOnBase() == null)){			
		currentField.one.movePlayerToNextBase();
	}
	
	else {
		currentField.one.addPlayerToBase(p);
	}
}

private void newPlayerOnBasesHomerun(Player p){
	//System.out.println("Homerun!!");
	addStringToOutput("homerun!");
	
	if(!(currentField.three.getPlayerOnBase() == null)){
		currentField.three.movePlayerToNextBase();
		currentField.addScore();
		//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
		addStringToOutput(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	if(!(currentField.two.getPlayerOnBase() == null)){
		currentField.two.movePlayerToNextBase();
		currentField.three.movePlayerToNextBase();
		currentField.addScore();
		//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
		addStringToOutput(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	if(!(currentField.one.getPlayerOnBase() == null)){
		currentField.one.movePlayerToNextBase();
		currentField.two.movePlayerToNextBase();
		currentField.three.movePlayerToNextBase();
		currentField.addScore();
		//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
		addStringToOutput(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	currentField.one.addPlayerToBase(p);
	currentField.one.movePlayerToNextBase();
	currentField.two.movePlayerToNextBase();
	currentField.three.movePlayerToNextBase();
	currentField.addScore();
	//System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	addStringToOutput(currentField.home.getPlayerOnBase() + " has scored");
	//System.out.println("amount of outs " + currentField.getOuts());
	addStringToOutput("amount of outs " + currentField.getOuts());
}

public String[] getOutput(){
	return (String[]) outputList.toArray();
}

public void printOutputList(){
	for(String s : outputList){
		System.out.println(s);
	}
}

public void addStringToOutput(String string){
	outputList.add(string);
}
}
