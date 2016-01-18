package baseballGamePackage;
import fieldPackage.Base;
import teamPackage.Player;

public class Tester {

public static void main(String[] args){
	Player bo = new Player("bo" , 55);
	
	Base one = new Base();
	Base two = new Base();
	Base three = new Base();
	Base home = new Base();
	
	one.setName("1st");
	one.setNextBase(two);
	
	two.setName("2nd");
	two.setNextBase(three);
	
	
	three.setName("3rd");
	three.setNextBase(home);
	
	home.setName("home");
	
	System.out.println("Is a player on 1st base? " + one.isBaseFull());
	System.out.println("Is a player on 2nd base? " + two.isBaseFull());
	System.out.println("Is a player on 3rd base? " + three.isBaseFull());
	System.out.println("Is a player on home plate? " + home.isBaseFull());
	
	one.addPlayerToBase(bo);
	
	System.out.println();
	System.out.println("Is a player on 1st base? " + one.isBaseFull());
	System.out.println("Is a player on 2nd base? " + two.isBaseFull());
	System.out.println("Is a player on 3rd base? " + three.isBaseFull());
	System.out.println("Is a player on home plate? " + home.isBaseFull());
	
	one.movePlayerToNextBase();
	
	System.out.println();
	System.out.println("Is a player on 1st base? " + one.isBaseFull());
	System.out.println("Is a player on 2nd base? " + two.isBaseFull());
	System.out.println("Is a player on 3rd base? " + three.isBaseFull());
	System.out.println("Is a player on home plate? " + home.isBaseFull());
	
	two.movePlayerToNextBase();
	
	System.out.println();
	System.out.println("Is a player on 1st base? " + one.isBaseFull());
	System.out.println("Is a player on 2nd base? " + two.isBaseFull());
	System.out.println("Is a player on 3rd base? " + three.isBaseFull());
	System.out.println("Is a player on home plate? " + home.isBaseFull());
	
	three.movePlayerToNextBase();
	
	System.out.println();
	System.out.println("Is a player on 1st base? " + one.isBaseFull());
	System.out.println("Is a player on 2nd base? " + two.isBaseFull());
	System.out.println("Is a player on 3rd base? " + three.isBaseFull());
	System.out.println("Is a player on home plate? " + home.isBaseFull());
}
}

