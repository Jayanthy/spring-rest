package student.registration.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import student.registration.exceptionhandler.StudentNotFoundException;
import student.registration.model.Student;

@Repository
public class StudentDemographDAOImpl implements StudentDemographDAO {

	@Autowired
	private SessionFactory factory;

	public List<Student> getAllStudents() {
		Session session = factory.getCurrentSession();
		List<Student> students = session.createQuery("from Student", Student.class).getResultList();

		return students;
	}

	public Student getStudent(int id) {
		Session session = factory.getCurrentSession();
		Student theStudent = session.get(Student.class, id);

		return theStudent;
	}

	@Transactional
	public void saveStudent(Student theStudent) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(theStudent);
	}


	public void deleteStudent(int id) {
		Session session = factory.getCurrentSession();
		Student theStudent = session.get(Student.class, id);
		if(theStudent == null)
			throw new StudentNotFoundException("Unable to delete student ID "+id + " because it does not exist");
		
		session.delete(theStudent);
	}

}
