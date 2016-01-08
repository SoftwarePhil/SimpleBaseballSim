package uncommentedCode;

public class Player { 

private String name;
private int battingStrength;

public Player(String aName, int aBattingStrength){
	name = aName;
	battingStrength = aBattingStrength;
}

public String getName(){
	return name;
}

public int getBattingStrength(){
	return battingStrength;
}

public String toString(){
	return "Player Name : " + name + "\n" + "Player Batting Strength : " + battingStrength;
}

}
