package com.code.cruddemo;

import com.code.cruddemo.dao.StudentDAO;
import com.code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student object ...");
		Student tempStudent = new Student("paul","Doe","hj3283@gmail.com");
		System.out.println("Saving the Student ...");
		studentDAO.save(tempStudent);
		System.out.println("Saved student Generated id: " + tempStudent.getId());
	}
}
