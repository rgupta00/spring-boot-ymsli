package com.javacodegeeks.examples.repository;

import org.springframework.data.repository.CrudRepository;

import com.javacodegeeks.examples.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
