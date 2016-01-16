package uncommentedCode;

public class Batting {

private int chanceOfBall = 0;
private int chanceOfStrike = 0;
private int chanceOfHit = 0;
private int chanceOfFoul = 0;
private int strikes;
private int balls;

private String stringOutput; 
private CurrentBatting currentBatting;

public int startBatting(CurrentBatting currentBatting, boolean print){
	balls = 0;
	strikes = 0;
	stringOutput = "";
	
	this.currentBatting = currentBatting;
	int bases = atBat();
	
	if(print){
		System.out.println(stringOutput);
	}
	
	return bases;
}

private void generateRates(){
	int pitchingSpeed
				= currentBatting.getPitcher().generatePitchingSpeed();
	int battingStrength
				= currentBatting.getPlayer().getBattingStrength();

	chanceOfBall = pitchingSpeed / 3;
	chanceOfHit = (battingStrength + pitchingSpeed)/4;
	chanceOfFoul = battingStrength / 3;
	chanceOfStrike = 99 - (chanceOfBall + chanceOfHit + chanceOfFoul);

	if(chanceOfStrike < 0){
		chanceOfStrike = Math.abs(chanceOfStrike);
		chanceOfHit = chanceOfHit - chanceOfStrike;
	}
	
	int total = chanceOfBall + chanceOfHit + chanceOfFoul
			+ chanceOfStrike;
	
	if(!(total == 99)){
		chanceOfBall = Math.round((float)chanceOfBall/total * 99);
		chanceOfHit =  Math.round((float)chanceOfHit/total * 99);
		chanceOfFoul =  Math.round((float)chanceOfFoul/total * 99); 
		chanceOfStrike =  Math.round((float)chanceOfStrike/total * 99);
		
		total = chanceOfBall + chanceOfHit + chanceOfFoul
				+ chanceOfStrike;
		
		if((total > 99)){
			chanceOfFoul = chanceOfFoul - (total - 99);
		}
		
		if((total < 99)){
			chanceOfFoul = (99 - total) + chanceOfFoul;
		}
	}
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
		stringOutput = stringOutput + "Ball " + balls + 
							" outcome " + temp + "\n";
		return 1;
	}
	//strike
	else if(temp < chanceOfBall + chanceOfStrike){
		currentBatting.addStrike();
		strikes = currentBatting.getStrikes();

		stringOutput = stringOutput + "Strike " + strikes + 
									" outcome " + temp + "\n";
		return 1;
	}
	//foul
	else if (temp < chanceOfBall + chanceOfStrike + chanceOfFoul){
		if(currentBatting.getStrikes() < 2){
			currentBatting.addStrike();
			strikes = currentBatting.getStrikes();

			stringOutput = stringOutput + "Foul that was strike " + 
						strikes + " outcome " + temp + "\n";
			
			return 1;
		}
		else {
			currentBatting.addFoul();
			
			stringOutput = stringOutput + "foul " + 
					currentBatting.getFouls() + " outcome " + temp + "\n";
			
			return 1;
		}
	}
	//hit
	else{
		stringOutput = stringOutput + "Ball was hit by \n" + 
				currentBatting.getPlayer() + " outcome = " + temp + "\n";
		
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
	return "Chance of ball: " + chanceOfBall + "\n" + "Chance of hit: " + 
			chanceOfHit + "\n" + "Chance of foul: " + chanceOfFoul + 
			"\n" + "Chance of strike: " + chanceOfStrike + "\n";
}
}
