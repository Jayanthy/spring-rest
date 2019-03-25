package student.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.registration.exceptionhandler.StudentNotFoundException;
import student.registration.model.Student;
import student.registration.service.StudentDemographService;

@RestController
@RequestMapping("/api/demograph")
public class StudentDemographController {
	
	@Autowired
	StudentDemographService serviceObj;
	
	@GetMapping("/students")
	public List<Student> getStudents() {		
		return serviceObj.getAllStudents();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Student theStudent =  serviceObj.getStudent(studentId);
		if(theStudent == null)
			throw new StudentNotFoundException("Student id "+studentId+ " not found");
		
		return theStudent;
	}
	
	@PostMapping("/students")
	public void addStudent(@RequestBody Student theStudent) {
		serviceObj.saveStudent(theStudent);
	}
	
	@PutMapping("/students")
	public void updateStudent(@RequestBody Student theStudent) {
		serviceObj.saveStudent(theStudent);
	}
	
	@DeleteMapping("/students/{studentId}")
	public void deleleStudent(@PathVariable int studentId)
	{
		serviceObj.deleteStudent(studentId);
	}
}
