package fieldPackage;
import teamPackage.Team;

public class CurrentField {

private int score = 0;
private int outs = 0;
	
protected Base home = new Base();
protected Base one = new Base();
protected Base two = new Base();
protected Base three = new Base();

public Ball ball = new Ball();

private int rows = 4;
private int columns = 5;

FieldSquare[][] gridFieldArray = new FieldSquare[rows][columns];

public CurrentField(){
	one.setName("1st");
	one.setNextBase(two);
	
	two.setName("2nd");
	two.setNextBase(three);
	
	three.setName("3rd");
	three.setNextBase(home);
	
	home.setName("home");
	
	for(int x = 0; x < rows; x++){
		for(int y = 0; y < columns; y++){
			gridFieldArray[x][y] = new FieldSquare(false, null);
		}
	}
	
	gridFieldArray[0][0].setKey("LF", 15);
	gridFieldArray[0][2].setKey("CF", 15);
	gridFieldArray[0][4].setKey("RF", 15);
	gridFieldArray[1][1].setKey("SS", 8);
	gridFieldArray[2][2].setKey("P", 8);
	gridFieldArray[1][2].setKey("2B", 8);
	gridFieldArray[3][0].setKey("3B", 8);
	gridFieldArray[3][2].setKey("C", 8);
	gridFieldArray[3][4].setKey("1B", 5);

}

public void start(Team fieldingTeam){
	score = 0;
	outs = 0;
	home.removePlayerOnBase();
	one.removePlayerOnBase();
	two.removePlayerOnBase();
	three.removePlayerOnBase();
	
	gridFieldArray[0][0].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[0][2].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[0][4].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[2][1].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[2][2].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[2][3].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[3][0].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[3][2].setFielder(fieldingTeam.getNextPlayer());
	gridFieldArray[3][4].setFielder(fieldingTeam.getNextPlayer());
}

public void resetOuts(){
	outs = 0;
}

public void putBallIntoRandomSquare(){
	ball.setPostion((int)(Math.random()*4), (int)(Math.random()*5));
	//ball.setPostion(0, 0);
}

public void putBallIntoRandomInFieldSquare(){
	ball.setPostion(((int)(Math.random()*2) + 2), (int)(Math.random()*4));
}

public boolean wasBallCaught(int x, int y){
	return gridFieldArray[x][y].wasBallCaught();
}

public int getScore() {
	return score;
}
public void addScore() {
	score = score +1;
}
public int getOuts() {
	return outs;
}
public void addOneToOuts() {
	outs = outs + 1;
}
public String toString(){
	return "base 1 " +one.toString() + "\n" + "base 2 " +two.toString() + "\n"
			+ "base 3 " +three.toString() + "\n";
}
}
