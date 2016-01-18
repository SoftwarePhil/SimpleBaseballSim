package fieldPackage;

import teamPackage.Player;

public class FieldSquare {

private boolean hasBall;
private String key;
private int[] playerSpace;
private Player fielder;

public FieldSquare(){
	setHasBall(false);
}

public FieldSquare(boolean ball, String position){
	setHasBall(ball);
	setKey(position, 10);
}

public void setSize(int size){
	playerSpace = new int[size];
}

public boolean getHasBall() {
	return hasBall;
}

public void setHasBall(boolean hasBall) {
	this.hasBall = hasBall;
}

public String getKey() {
	return key;
}

public void setKey(String key, int size) {
	this.key = key;
	setSize(size);
}

public Player getFielder() {
	return fielder;
}

public void setFielder(Player fielder) {
	this.fielder = fielder;
	for(int i = 0; i < playerSpace.length; i++){
		if(i < 50){
		playerSpace[i] = fielder.getFieldingStrength() - (i);
		}
		else {
			playerSpace[i] = 60;
		}
	}
}

public boolean wasBallCaught(){
	int index = (int)(Math.random() * (playerSpace.length-1));
	int temp2 = (int)(Math.random() * 300);
	//System.out.println("chance " + (100 - playerSpace[index]) + " random num " + temp2);
	if((temp2 > (100 - playerSpace[index]))){
		//System.out.println("BALL HAS BEEN CAUGHT OUT");
		return true;
	}
	else return false;
}

}
