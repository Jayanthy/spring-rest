package student.registration.dao;

import java.util.List;

import student.registration.model.Student;

public interface StudentDemographDAO {
	
	public List<Student> getAllStudents();
	public Student getStudent(int id);
	public void saveStudent(Student theStudent);
	public void deleteStudent(int id);
}
