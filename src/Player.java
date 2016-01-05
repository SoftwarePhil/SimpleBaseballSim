//the word public and class are key words that let the compiler know we
//are about to make a class, the word Player is the name of our class
public class Player {
//notice the curly brakes, all the code for our player class will go inside them 

//here we are declaring a instance variable of type String called name
//notice the key word private
//this means only the things inside the class can access it, encapsulation 
//Strings are a type of variable that store letters, let the ones you are reading
//We must specify the type of a variable, when declaring a new variable
//also take note of the semicolon, all statements must end with a semicolon 
private String name;

//here we are declaring an instance variable of type int called battingStrength
//like before we have the word private, specify the type, followed by the name of the variable
//int are a data type that hold integer numbers (a whole number like 1 and not 3.14) 
//this number must fall between -2,147,483,648 and 2,147,483,648
private int battingStrength;

//Okay now that we have created our instance variables lets give them some values!
//we can do this by making something called a constructor
//a constructor is a special kind of method that gets called when an object is made
//notice the key word public followed by the name of our class
//inside our parenthesis we have parameters, these are values that we need for our class
//we need a String and an int to give values to our instance variables
//notice how we curly brackets following the end of the parenthesis 
	//inside these brackets we have the code that will run when we make a new Player object
public Player(String aName, int aBattingStrength){

//lets assign the value of aName from our parameter to the value of our String called name
//it is important to remember that the variable aName will contain a String
	//we just do not know what the exact value will be
//notice how we have name on the left side and aName on the right side
	//this statement, terminated by a semicolon
//is basically saying "I want the instance variable name to have the same value as aName"
//this is called assignment, we use an equal sign, but we are not checking for equality  
	name = aName;
	
//like before we are assigning the value found in aBattingStrength to battingStrength
//for example if aBattingStrength has a value of 25
	//after the statement is ran, battingStrength will also have a value of 25
	battingStrength = aBattingStrength;
}

//here we are making a method called getName, we are doing this so that we can access the value
	//of name from outside the class, remember the instance variable name is private
	//and due to encapsulation, this method is the only way we can get the value of name
	//from outside the class, this will make more sense when make create a player object
//notice the key word public followed by String, the data type of name, followed
public String getName(){
	return name;
}


}
