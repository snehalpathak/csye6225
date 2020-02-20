package com.cyse6225.spring2020.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cyse6225.spring2020.courseservice.datamodel.Course;
import com.cyse6225.spring2020.courseservice.datamodel.Lecture;
import com.cyse6225.spring2020.courseservice.datamodel.Professor;
import com.cyse6225.spring2020.courseservice.datamodel.Student;
import com.cyse6225.spring2020.courseservice.service.CourseService;

@Path("courses")
public class CourseResourse {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return CourseService.getInstance().getAllCourses();
	}

	//get course by id
	@GET
	@Path("{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course getCoursebyId(@PathParam("courseId") String courseId) {
		return CourseService.getInstance().getCoursebyId(courseId);
	}
	
	//get course TA
	@GET
	@Path("{courseId}/ta")
	public Student getCourseTA(@PathParam("courseId") String courseId) {
		return CourseService.getInstance().getStudentTAforCourse(courseId);
	}
	
	//get course prof
	@GET
	@Path("{courseId}/professor")
	public Professor getProfessor(@PathParam("courseId") String courseId) {
		return CourseService.getInstance().getProfessorforCourse(courseId);
	}
	
	//get course lect
	@GET
	@Path("{courseId}/lecture")
	public Lecture getLecture(@PathParam("courseId") String courseId) {
		return CourseService.getInstance().getLectureDetailsforCourse(courseId);
	}
	
	//add
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		CourseService.getInstance().addCourse(course.getCourseId(), course.getCourseName(), course.getLectureId(), course.getProfessorId(), course.getCourseTA());
		return course;
	}
	
	//delete
	@DELETE
	@Path("{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseId") String courseId) {
		return CourseService.getInstance().deleteCourse(courseId);
	}
	
	//update
	@PUT
	@Path("{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseId") String courseId, Course course) {
		return CourseService.getInstance().updateCourse(courseId, course);
	}
	
}
