
public class Batting {

//these variables will be used to calculate what outcome of a swing
//will be
private int chanceOfBall = 0;
private int chanceOfStrike = 0;
private int chanceOfHit = 0;
private int chanceOfFoul = 0;

private int strikes;
private int balls;

private String stringOutput;

//this object stores the current Player and Pitcher
//as well as strikes, balls, and fouls
//and a special attribute that handles the case of a homerun
	//or walk, the way the player will move around the bases
	//will be different in these cases 
private CurrentBatting currentBatting;

//this constructor takes an instance of CurrentBatting
	//we set balls and strikes equal to zero
//note the return atBat()
//this method is returning the number of bases a player can move
//the print boolean determines if anything gets printed or not
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

//since the pitch speed varies with each pitch 
//we need to recalculate batting outcomes with each pitch 
private void generateRates(){
	int pitchingSpeed
				= currentBatting.getPitcher().generatePitchingSpeed();
	int battingStrength
				= currentBatting.getPlayer().getBattingStrength();
	
	//the following ways these are calculated are arbitrary
	//these will need to be changed when we start using real data
	//you may adjust these to what ever you like as long as
		//the total of these 4 add up to 99
	chanceOfBall = pitchingSpeed / 3;
	chanceOfHit = (battingStrength + pitchingSpeed)/4;
	chanceOfFoul = battingStrength / 3;
	chanceOfStrike = 99 - (chanceOfBall + chanceOfHit + chanceOfFoul);
	
	//this checks to see if chanceOfStike negative
		//if chanceOfStrike is negative we need to correct it
		//the 4 numbers must still add up to 99
	if(chanceOfStrike < 0){
		chanceOfStrike = Math.abs(chanceOfStrike);
		chanceOfHit = chanceOfHit - chanceOfStrike;
	}
	
	//the total of these values
	int total = chanceOfBall + chanceOfHit + chanceOfFoul
			+ chanceOfStrike;
	
	//a check and fix
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

//this method returns the number of bases a Player can move
	//this number is between 0 and 4, with 0 being a strike out
	//and 4 being a homerun 
//this method will simulate a ball being pitched to a Player
//it will keep pitching until the Player has struck out,
//or until the Player has hit the ball
	//the number of bases a Player can move will be
	//determined by the hit() method
private int atBat(){
	//sets strikes equal to the amount stored in currentBatting
	strikes = currentBatting.getStrikes();
	//sets balls equal to the amount stored in currentBatting
	balls = currentBatting.getBalls();
	
	//a loop that runs until the batter strikes out or
		//hits the ball
	while(strikes <= 2 && balls <= 3){
		//updates rates based on the pitch speed
		generateRates();
		
		//the pitch method determines the outcome of a pitch
		int outcome = pitch();
		
		//if the ball was hit return the amount of bases to move
		if(outcome == 0){
			return hit();
		}
	}
	//checks to see if 4 balls have happened
	if(currentBatting.getBalls() == 4){
		//when 4 balls have happened we set the value to walk
		currentBatting.setHomerunOrWalk("walk");
		//the Player must move one base
		return 1;
	}
	//if we reach this point it means the batter has struck out
	return 0;
}

//if this method returns 1 it means the ball was not hit
private int pitch(){
	//this generates a random number between 0 and 99
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
		//if there are less than 2 strikes
			//we need to count fouls as strikes 
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

//this method determines how many bases a Player will move after
	//hitting the ball
//if this method has been called it means the Player has
	//hit the ball
private int hit(){
	//generates a number between 0 and 99
	int temp = (int)(Math.random() * 100);
	
	//if the Player is good (battingStrength over 50)
		//these are his chances of getting a single, double,
		//triple, or homerun
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
