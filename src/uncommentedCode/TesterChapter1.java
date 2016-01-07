package uncommentedCode;

//we are making a new class called tester
public class TesterChapter1 {

//all Java programs need a main method, this is how we declare a main method
	//don't worry too much about what this method is actual doing
	//just understand that all the code that you want to be run
	//must be inside a main method
public static void main(String[] args){
	
//here we are making an instance of our player object
	//first we have the class name, which is Player
	//followed by the variable name, which in this case is bob
	//followed by an equal sign (remember assignment from before?)
	//followed by the keyword new
	//followed by calling the constructor of our Player object
		//this runs the code in the constructor we wrote
			//inside the parenthesis we pass in a String with the value Bob Smith
			//note the quotation marks around the Bob Smith, we must surround strings
			//with quotation marks
			//next we see a comma this is used to separate things we are passing into methods
			//following this is the number 44
			//if we look at our constructor we see that the constructor expects to see
			//a String and an integer, and that is exactly what we are giving it
				//we would not be able to instantiate a Player object if different arguments
				//were to be passed in, for example if we tried to pass in two strings, the
				//program would not compile
	//we end are statement with a semicolon 
	Player bob = new Player("Bob Smith", 44);
		/*this can also be written in two lines which might be easier to understand
		Player bob;
		bob = new Player("Bob Smith", 44);
		*/
	
	//this is the same thing we did before except we are using different values
	//this Player is very different from the first player we made and inside our
	//baseball simulation they will perform very differently from each other
	//in more simple terms this line is saying
		//make me a player object with the name steve that hold the player Steve Harris
		//who has a batting strength of 54
	Player steve = new Player("Steve Harris", 54);
	
	//here we are making a new variable of type String
		//the variable has the name steveName
		//we are assigning the value of steve.getName() to steveName
		//the object steve, which is of type Player has a method called getName()
			//this method will get value of the name instance variable that
			//is contained inside the steve object we just made
		//we can access the getName() method by using the dot operator
		//steve.getName() will call the getName() method contained that Player object
	//steveName now equals "Steve Harris"
	String steveName = steve.getName();
	
	//how can we verify that steveName has the value "Steve Harris"?
	//we can verify this by using the Java library
	//don't worry too much about the words, just remember that when you want to print something
	//you can use System.out.println();
	//what you want to print goes inside the parenthesis
		//variables do not need to have quotation marks around them
		//we can also input Strings directly into the println
			//"Player name is " is an example of this
			//we can combine two Strings together by using the plus sign
				//this is called concatenation 
	System.out.println("Player name is " + steveName);
	
	//here we are doing the same thing for the battingStrength variable for our 
	//Player object called steve
		//note that this time we are getting an integer returned to us rather than a string
	int steveBatting = steve.getBattingStrength();
	System.out.println("Player batting strength is " + steveBatting);	

//this ends our main method
}

//this ends our tester class
}
