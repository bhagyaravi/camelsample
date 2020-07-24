package com.test.quarkus;

import org.springframework.data.repository.CrudRepository;


public interface StudentRepository  extends CrudRepository<Student,Long>{

}
