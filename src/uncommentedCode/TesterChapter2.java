package uncommentedCode;

//we are making a new class called tester
public class TesterChapter2 {

//all Java programs need a main method, this is how we declare a main method
public static void main(String[] args){

	//creating a new Pitcher object called myPitcher
		//his name is Bob the Pitcher
		//his battingStrength is 25
		//his pitchingStrength is 60
		//we expect his pitchs to be thrown at a speed between 20 and 110
	Pitcher myPitcher = new Pitcher("Bob the Pitcher", 25, 60);
	
	//creating a variable called pitchingSpeed and inilitlizing it to 0
	int pitchingSpeed = 0;
	
	//we have the keyword for
	//following this we have declare a variable i and set it equal to 0
		//note the semicolon
	//following this we have a condition, note the semicolon
		//the for loop will continue to run the code inside the curly brackets
			//until the condition (i < 10) is no longer true
			//the pitching speed will be printed 10 times
		//the last part of the for loop increases i by 1
			//this happens each time the for loop runs
		//thus eventually making i greater than 10
	for(int i = 0; i < 10; i++){
		//we are setting pitchingSpeed equal to the value returned by the
			//generatePitchingSpeed() method
			//we should expect a different value each time
			//we can access the methods of an object by using a dot	
				//followed by the name of the method
		pitchingSpeed = myPitcher.generatePitchingSpeed();
		
		//the value returned by generatePitchSpeed() is being printed
		System.out.println("the ball was thrown at " + pitchingSpeed);
	}
//this ends our main method
}

//this ends our tester class
}
