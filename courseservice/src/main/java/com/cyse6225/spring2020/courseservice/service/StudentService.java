package com.cyse6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cyse6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.cyse6225.spring2020.courseservice.datamodel.Student;

public class StudentService {

	private static HashMap<String, Student> studentMap = InMemoryDatabase.getStudentDB();

	private static StudentService instance;

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public void addStudent(String studentId, String name, String email, String program, List<String> courseId) {
		Student newStudent = new Student(studentId, name, email, program, courseId);
		System.out.println(newStudent);
		studentMap.put(studentId, newStudent);
	}

	public Student deleteStudent(String studentId) {
		Student oldStudent = studentMap.get(studentId);
		studentMap.remove(studentId);
		return oldStudent;
	}

	public Student getStudentById(String id) {
		return studentMap.get(id);
	}

	public List<Student> getAllStudents() {
		ArrayList<Student> list = new ArrayList<>();
		for (Student student : studentMap.values()) {
			list.add(student);
		}
		return list;
	}

	public List<Student> getStudentbyProgram(String programId) {
		List<Student> studentList = new ArrayList<Student>();
		for (Student student : studentMap.values()) {
			if (student.getProgramId().equals(programId)) {
				studentList.add(student);
			}
		}
		return studentList;
	}

	public Student updateStudent(String id, Student student) {
		studentMap.put(id, student);
		Student modifiedStudent = studentMap.get(id);
		return modifiedStudent;
	}

	// get course list for student
	public List<String> getCourseListForStudent(String studentId) {
		List<String> courseList = new ArrayList<>();

		for (Student student : studentMap.values()) {
			if (student.getStudentId().equals(studentId)) {
				courseList = student.getCourseId();
			}
		}
		return courseList;
	}
}
