//a class called Pitcher is being defined here, this class is extending Player
	//this Pitcher has a relationship with Player that is defined by inheritance
	//Pitcher is a child of Player
	//Pitcher has all the same instance variables and methods as Player
public class Pitcher extends Player {

//a variable called pitchingStrength of type int
private int pitchingStrength;

//a constant integer called SPEEDCONST, storing the value 50
	//this number will not change throughout the course of the program running
//the keyword static means that the same instance variable is shared among all 	//Pitcher objects
//the keyword final means that the value cannot be changed
private static final int SPEEDCONST = 50;

//a constant integer called MINPITCHSPEED, storing the value 20
private static final int MINPITCHSPEED = 20;
	
//the constructor for the Pitcher class, this will be called for each new Pitcher object made
	//note how we take the same two parameters that the Player class needs
//the last parameter, aPitchingStrength is going the value that the Pitcher class //needs
public Pitcher(String aName, int aBattingStrength, int aPitchingStrength) {

//the keyword super is calling the constructor from the Player object
	//this must be the first line of in our constructor
	super(aName, aBattingStrength);
	
//here we are assigning the value that we passed into the constructor into pitchingStrength
	pitchingStrength = aPitchingStrength;
}

//this is defining the method called getPitchingSpeed, this method returns an integer
	//this method will determine how fast a pitcher has pitched a ball
public int generatePitchingSpeed(){
	//a variable of type int is being declared
		//note that we do not need to give it a value
	int speed;
	
	//see page 2.3 - 2.5
	//a variable called int is being assigned a random value between 0 and SPEEDCONST
	int randNum = (int)(Math.random()*SPEEDCONST);
	
//here we are using an if...else structure to decide if we want to add or subtract //randNum
//the % sign means randNum modulus 0, this is checking if the number is //even or odd
//% sign computes the remainder from division
		//for example 4 % 2 is equals 0, 5 % 2 equals 1, 10 % 101 equals 1
	//the code inside this if statement will only execute if randNum % 2 equals 0
		//meaning randNum is even
	if(randNum % 2 == 0){
		
		//speed equals pitchingStrength minus randNum
		speed = pitchingStrength - randNum;
	}
	
	//this statement will only execute if the above if statement turns out to not be true
		//this means that randNum % 2 is equal to 1, or that randNum is odd
	else{
		//speed equals pitchingStrength plus randNum
		speed = pitchingStrength + randNum;
	}
	
	//this is checking if speed is less then MINPITCHSPEED
	if(speed < MINPITCHSPEED){
		
//if speed is less then MINPITCHSPEED we set speed equal to MINPITCHSPEED
		speed = MINPITCHSPEED;
	}
	
	//this statement is returning the final value of speed
	return speed;
	}

public String toString(){
	return super.toString() + "\n" +  "Player Pitching Strength : " + pitchingStrength;
}
}

