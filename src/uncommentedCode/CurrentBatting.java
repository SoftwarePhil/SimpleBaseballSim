package uncommentedCode;
public class CurrentBatting {

private int strikes = 0;
private int fouls = 0;
private int balls = 0;
private Player player;
private Pitcher pitcher;
private String homerunOrWalk;

public CurrentBatting(Player player, Pitcher pitcher){
	this.player = player;
	this.pitcher = pitcher;
}


public void addStrike() {
	strikes = strikes + 1;
}

public void addBall(){
	balls = balls + 1;
}

public void addFoul(){
	fouls = fouls + 1;
}

public int getStrikes(){
	return strikes;
}

public int getBalls() {
	return balls;
}

public void setBalls(int balls) {
	this.balls = balls;
}

public int getFouls() {
	return fouls;
}

public void setFouls(int fouls) {
	this.fouls = fouls;
}

public Player getPlayer() {
	return player;
}

public Pitcher getPitcher() {
	return pitcher;
}

public void setHomerunOrWalk(String homerunOrWalk) {
	this.homerunOrWalk = homerunOrWalk;
}

public String getHomerunOrWalk() {
	return homerunOrWalk;
}
}
