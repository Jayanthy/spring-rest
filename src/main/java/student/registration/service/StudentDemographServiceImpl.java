package student.registration.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.registration.dao.StudentDemographDAO;
import student.registration.model.Student;

@Service
public class StudentDemographServiceImpl implements StudentDemographService {
	
	@Autowired
	StudentDemographDAO daoObj;
	
	@Transactional	
	public List<Student> getAllStudents() {
		return daoObj.getAllStudents();
	}
	
	@Transactional
	public Student getStudent(int id) {
		return daoObj.getStudent(id);
	}
	
	@Transactional
	public void saveStudent(Student theStudent) {
		daoObj.saveStudent(theStudent);
	}

	@Transactional
	public void deleteStudent(int id) {
		daoObj.deleteStudent(id);
	}

}
