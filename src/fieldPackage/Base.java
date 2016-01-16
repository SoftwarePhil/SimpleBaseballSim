package fieldPackage;

import teamPackage.Player;

public class Base {

private Base nextBase;
private Player playerOnBase;
private String name;

public void addPlayerToBase(Player p){
	playerOnBase = p;
}

public void removePlayerOnBase(){
	playerOnBase = null;
}

public void movePlayerToNextBase(){
	nextBase.addPlayerToBase(playerOnBase);
	removePlayerOnBase();
}

public Player getPlayerOnBase(){
	return playerOnBase;
}

public void setNextBase(Base base){
	nextBase = base; 
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isBaseFull(){
	if(playerOnBase == null){
		return false;
	}
	else{
		return true;
	}
}

public String toString(){
	return "Player " + playerOnBase.getName() + " is on " +
			name;
}
}
