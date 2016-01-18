package teamPackage;
//the word public and class are keywords that let the compiler know we
//are about to make a class, the word Player is the name of our class
public class Player {
//notice the curly brakes, all the code for our player class will go inside them 

//here we are declaring an instance variable of type String called name
//notice the keyword private
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

private int fieldingStrength;

//Okay now that we have created our instance variables lets give them some values!
//we can do this by making something called a constructor
//a constructor is a special kind of method that gets called when an object is made
//notice the key word public followed by the name of our class
//inside our parenthesis we have parameters, these are values that we need for our class
//we need a String and an int to give values to our instance variables
public Player(String aName, int aBattingStrength){
//notice how we curly brackets following the end of the parenthesis 
	//inside these brackets we have the code that will run when we make a new Player object
	
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

public Player(String aName, int aBattingStrength, int aFieldingStrength){
	name = aName;
	battingStrength = aBattingStrength;
	fieldingStrength = aFieldingStrength;
}

//here we are making a method called getName, we are doing this so that we can access the value
	//of name from outside the class, remember the instance variable name is private
	//and due to encapsulation, this method is the only way we can get the value of name
	//from outside the class, this will make more sense when make create a player object
//notice the keyword public followed by String, the data type of name, followed an
	//empty set of parenthesis (these are empty because this method requires values passed into it)
	//unlike our constructor we made before, this method requires no information
	//to get the value of name
public String getName(){
//once again we have our curly brackets surrounding the code that defines getName()
	
//here we have the keyword return, this statement sends the value to where the method is
//being called, this will all come together soon, just stick with me for tiny bit longer
	return name;
}

//this method is the same as the one above except it is returning an integer
public int getBattingStrength(){
	return battingStrength;
}

public int getFieldingStrength() {
	return fieldingStrength;
}

public String toString(){
	return "Player Name : " + name + "\n" + "Player Batting Strength : " + battingStrength;
}

//this ending brace completes our Player class! Now lets see how to use it!
}
