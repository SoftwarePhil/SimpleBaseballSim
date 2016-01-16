package uncommentedCode;

public class Player { 

private String name;
private int battingStrength;
private int fieldingStrength;

public Player(String aName, int aBattingStrength){
	name = aName;
	battingStrength = aBattingStrength;
}

public Player(String aName, int aBattingStrength, int aFieldingStrength){
	name = aName;
	battingStrength = aBattingStrength;
	fieldingStrength = aFieldingStrength;
}

public String getName(){
	return name;
}

public int getBattingStrength(){
	return battingStrength;
}

public int getFieldingStrength() {
	return fieldingStrength;
}

public void setFieldingStrength(int fieldingStrength) {
	this.fieldingStrength = fieldingStrength;
}

public String toString(){
	return "Player Name : " + name + "\n" + "Player Batting Strength : " + battingStrength;
}

}
