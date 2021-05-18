package com.sda.sdaScheduler;

import com.sda.sdaScheduler.hibernate.ModuleRepositoryHibernate;
import com.sda.sdaScheduler.hibernate.PersonRepositoryHibernate;
import com.sda.sdaScheduler.hibernate.TeamRepositoryHibernate;
import com.sda.sdaScheduler.jdbc.TeamRepository;
import com.sda.sdaScheduler.model.Module;
import com.sda.sdaScheduler.model.Person;
import com.sda.sdaScheduler.model.Team;

public class MainApplication {

	public static void main(String[] args) {
		
		
//		addTenTeams();
//		TeamRepository.getAllTeams();
//		TeamRepositoryHibernate.getTeamById(34);
//		Team team = new Team();
//		team.setIdTeam(34);
//		team.setMaxStudents(123);
//		team.setName("ElseGroup123");
//		Person person = new Person();
//		person.setEmail("danut@email.com");
//		person.setLastName("danut");
//		person.setTrainer(true);
//		TeamRepositoryHibernate.UpdateTeam(team);
//		PersonRepositoryHibernate.savePerson(person);
//		PersonRepositoryHibernate.getPersonById(1);
//		TeamRepositoryHibernate.saveTeam(team);
//		System.out.println("\n");
//		TeamRepository.updateTeam(35, "ElseGroup", 52);
//		TeamRepository.getAllTeams();
//		System.out.println("\n");
//		TeamRepository.selectNuLL();
//		TeamRepository.updateWhereNulL(2, "haha", 125);
		
		
//		Module modul1 = new Module(3, "05.04.2019", "04.05.2019");
		
//		ModuleRepositoryHibernate.getModuleById(1);
//		ModuleRepositoryHibernate.saveModule(module)
//		System.out.println(PersonRepositoryHibernate.selectAllTrainer(true));
//		System.out.println(PersonRepositoryHibernate.selectByFnAndLn("Dan", "Nastea"));
//		System.out.println(PersonRepositoryHibernate.selectTeamByStudentName("Dan"));
		System.out.println(ModuleRepositoryHibernate.selectGroupByMaxStudents());
		
		
		

	}
	
	public static void add20Teams() {
		for(int i = 0 ; i < 10; i++) {
			TeamRepository.insertNewTeam("Grupa " + i, i);
		}

	}

}
