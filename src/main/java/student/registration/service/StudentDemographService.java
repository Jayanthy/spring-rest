package student.registration.service;

import java.util.List;

import student.registration.model.Student;

public interface StudentDemographService {
	public List<Student> getAllStudents();
	public Student getStudent(int id);
	public void saveStudent(Student theStudent);
	public void deleteStudent(int id);
}
