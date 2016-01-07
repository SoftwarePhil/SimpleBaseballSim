package uncommentedCode;

public class TesterChapter2 {

public static void main(String[] args){
	Pitcher myPitcher = new Pitcher("Bob the Pitcher", 25, 60);
	int pitchingSpeed = 0;
	
	for(int i = 0; i < 10; i++){
		pitchingSpeed = myPitcher.generatePitchingSpeed();
		System.out.println("the ball was thrown at " + pitchingSpeed);
	}
}
}
