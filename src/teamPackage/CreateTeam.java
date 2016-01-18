package teamPackage;

public class CreateTeam {

public Team createTeam(String name){
	Player[] players = {
		new Player("bo", 60,100),
		new Player("mo", 20, 90),
		new Player("borry", 95, 80),
		new Player("mary", 33, 86),
		new Player("smith", 88, 34),
		new Player("jean", 56, 78),
		
		new Pitcher("po", 90, 56),
		new Pitcher("pop", 77, 80)
	};
	
	Team team = new Team(players, name);
	
	return team;
}

public Team[] createTeams(String name1, String name2){
	Team[] t  = new Team[2];
	
	t[0] = createTeam(name1);
	t[1] = createTeam(name2);
	
	return t;
}

}
