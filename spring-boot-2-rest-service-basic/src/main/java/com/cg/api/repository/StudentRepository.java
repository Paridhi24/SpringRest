package com.cg.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.api.entity.Student;

@Repository("studentRepository")
public interface StudentRepository extends CrudRepository<Student, Long> {

}
