
public class Batting {

private int chanceOfBall;
private int chanceOfStrike = 0;
private int chanceOfHit = 0;
private int chanceOfFoul = 0;

private int strikes;
private int balls;

private CurrentBatting currentBatting;

public int startBatting(CurrentBatting currentBatting){
	balls = 0;
	strikes = 0;
	
	this.currentBatting = currentBatting;
	return atBat();
}

private void generateRates(){
	int pitchingSpeed = currentBatting.getPitcher().generatePitchingSpeed();
	int battingStrength = currentBatting.getPlayer().getBattingStrength();
	
	chanceOfBall = pitchingSpeed / 2;
	chanceOfStrike = (battingStrength + pitchingSpeed);
	chanceOfFoul = battingStrength / 3;
	
	chanceOfHit = 100 - (chanceOfBall + chanceOfStrike + chanceOfFoul);
	
}

private int atBat(){
	strikes = currentBatting.getStrikes();
	balls = currentBatting.getBalls();
	
	while(strikes <= 2 && balls <= 3){
		generateRates();
		
		int outcome = pitch();
		
		if(outcome == 0){
			return hit();
		}
	}
	if(currentBatting.getBalls() == 4){
		currentBatting.setHomerunOrWalk("walk");
		return 1;
	}
	return 0;
}

private int pitch(){
	int temp = (int)(Math.random() * 100);
	
	//ball
	if(temp < chanceOfBall){
		currentBatting.addBall();
		balls = currentBatting.getBalls();
		System.out.println("Ball " + balls + " outcome " + temp);
		return 1;
	}
	//strike
	else if(temp < chanceOfBall + chanceOfStrike){
		currentBatting.addStrike();
		strikes = currentBatting.getStrikes();
		System.out.println("Strike " + strikes + " outcome " + temp);
		return 1;
	}
	//foul
	else if (temp < chanceOfBall + chanceOfStrike + chanceOfFoul){
		if(currentBatting.getStrikes() < 2){
			currentBatting.addStrike();
			strikes = currentBatting.getStrikes();
			System.out.println("Foul that was strike " + strikes + " outcome " + temp);
			return 1;
		}
		else {
			currentBatting.addFoul();
			System.out.println("foul " + currentBatting.getFouls() + " outcome " + temp);
			return 1;
		}
	}
	//hit
	else{
		System.out.println("Ball was hit by \n" + currentBatting.getPlayer() + " outcome = " + temp);
		return 0;
	} 
}

private int hit(){
	int temp = (int)(Math.random() * 100);
	
	if(currentBatting.getPlayer().getBattingStrength() > 50){
		if(temp < 50){
			return 1;
		}
		else if (temp < 94){
			return 2;
		}
		else if (temp < 96){
			return 3;
		}
		else {
			currentBatting.setHomerunOrWalk("homerun");
			return 4;
		}
	}
	else {
		if(temp < 70){
			return 1;
		}
		else if (temp < 97){
			return 2;
		}
		else if (temp < 98){
			return 3;
		}
		else {
			currentBatting.setHomerunOrWalk("homerun");
			return 4;
		}
	}
}

public String toString(){
	return "Chance of ball: " + chanceOfBall + "\n" + "Chance of hit: " + chanceOfHit + "\n" +
			"Chance of foul: " + chanceOfFoul + "\n" + "Chance of strike: " + chanceOfStrike + "\n";
}

}
