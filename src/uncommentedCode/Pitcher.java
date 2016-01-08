package uncommentedCode;

public class Pitcher extends Player {

private int pitchingStrength;
private static final int SPEEDCONST = 50;
private static final int MINPITCHSPEED = 20;

public Pitcher(String aName, int aBattingStrength, int aPitchingStrength) {
	super(aName, aBattingStrength);
	pitchingStrength = aPitchingStrength;
}

public int generatePitchingSpeed(){
	int speed;
	int randNum = (int)(Math.random()*SPEEDCONST);
	
	if(randNum % 2 == 0){
		speed = pitchingStrength - randNum; 
	}
	else{ 
		speed = pitchingStrength + randNum;
	}
	
	if(speed < MINPITCHSPEED){
		speed = MINPITCHSPEED;
	}
	
	return speed;
}

public String toString(){
	return super.toString() + "\n" +  "Player Pitching Strength : " + pitchingStrength;

}
}

