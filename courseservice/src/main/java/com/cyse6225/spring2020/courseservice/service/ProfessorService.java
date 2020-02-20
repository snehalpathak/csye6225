package com.cyse6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cyse6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.cyse6225.spring2020.courseservice.datamodel.Professor;

public class ProfessorService {
	
	private static HashMap<String, Professor> prof_Map = InMemoryDatabase.getProfessorDB();
	private static ProfessorService instance;
	
	public static ProfessorService getInstance() {
		if(instance == null) {
			instance = new ProfessorService();
		}
		return instance;
	}
	
	// Getting a list of all professor 
	// GET "..webapi/professors"
	public List<Professor> getAllProfessors() {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		return list ;
	}

	// Adding a professor
	public void addProfessor(String professorId, String firstName, String lastName, String department, String joiningDate) {
		//Create a Professor Object
		Professor prof = new Professor(professorId, firstName , lastName, 
				department, joiningDate.toString());
		
		prof_Map.put(professorId, prof);
	}
	
	
	// Getting One Professor
	public Professor getProfessor(String profId) {
		 Professor getProfDetails = prof_Map.get(profId);
	     System.out.println("Item retrieved:");
	     System.out.println(getProfDetails.toString());
		
		return getProfDetails;
	}
	
	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		Professor deletedProfDetails = prof_Map.get(profId);
		prof_Map.remove(profId);
		return deletedProfDetails;
	}
	
	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {	
		if(prof_Map.containsKey(profId)) {
			prof_Map.put(profId, prof);
		}
		return prof;
	}
	
	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equals(department)) {
				list.add(prof);
			}
		}
		return list ;
	}
	
	// Get professors for a year with a size limit
	
}
