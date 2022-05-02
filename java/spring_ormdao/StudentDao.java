package spring_ormdao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	
	
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//save student
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//for single object
	public Student getStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	//for multiple object
	public List<Student> getAllStudents()
	{
		List<Student> loadAll = this.hibernateTemplate.loadAll(Student.class);
		return loadAll;
	}
	//deleting the object
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	
	//updating the object
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

}
