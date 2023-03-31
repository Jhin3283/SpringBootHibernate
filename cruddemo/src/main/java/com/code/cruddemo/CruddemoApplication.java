package com.code.cruddemo;

import com.code.cruddemo.dao.StudentDAO;
import com.code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			readAllStudent(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteStudents(studentDAO);
		};
	}

	private void deleteStudents(StudentDAO studentDAO) {
		int numRows = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + numRows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Daffy","Duck", "daffy@gmail.com");
		studentDAO.save(tempStudent);
		int theId = tempStudent.getId();
		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the Student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 Students object ...");
		Student tempStudent1 = new Student("John","Doe","John@gmail.com");
		Student tempStudent2 = new Student("Jhin","jung","Jhin@gmail.com");
		Student tempStudent3 = new Student("Hee","Kim","Hee@gmail.com");
		System.out.println("Saving 3 Students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student object ...");
		Student tempStudent = new Student("paul","Doe","hj3283@gmail.com");
		System.out.println("Saving the Student ...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student Generated id: " + tempStudent.getId());
	}
}
