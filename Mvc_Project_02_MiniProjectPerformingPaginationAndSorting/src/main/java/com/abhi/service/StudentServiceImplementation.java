package com.abhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.abhi.entity.Student;
import com.abhi.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements IStudentService {
	@Autowired
	private StudentRepository repository;

	@Override
	public Page<Student> showAllDetails(Pageable pageable) {

		Page<Student> all = repository.findAll(pageable);

		return all;
	}

	@Override
	public String addStudent(Student student) {

		Student save = repository.save(student);

		return "student added with student id " + save.getId();
	}

	@Override
	public Student fatchEmployeeById(int id) {

		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
	}

	@Override
	public String editStudentDetails(Student student) {
		Optional<Student> byId = repository.findById(student.getId());
		if (byId.isPresent()) {
			Student save = repository.save(student);
			return save.getName() + " are update successfully";
		} else {

			return "some internal issue";
		}

	}

	@Override
	public String deleteEmployeeDetails(int id) {
		Optional<Student> byId = repository.findById(id);
		if (byId.isPresent()) {
			repository.deleteById(id);
			return "id " + id + " deleted Successfully";
		} else {
			return id + " record not found for the Deleation";
		}

	}

	/*@Override
	public List<Student> dynamicSearch(Student student) {
		if (student.getName() == null || student.getName().isEmpty()) {
			student.setName(null);
		}
		if (student.getEmail() == null || student.getEmail().isEmpty()) {
			student.setEmail(null);
		}
	
		Example<Student> example = Example.of(student);
	
		return repository.findAll(example);
	}*/

}
