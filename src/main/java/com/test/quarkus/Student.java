package com.test.quarkus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

@Id
@GeneratedValue
private long studentId;
private String name;
private String subject;
 

public Student(long id,String name, String subject) {
this.studentId = id;
this.name = name;
this.subject = subject;
}
 
public long getId() {
return studentId;
}
 
public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public void setId(long id) {
this.studentId = id;
}
 
public String getName() {
return name;
}
 
public void setName(String name) {
this.name = name;
}
 
public String getSubject() {
return subject;
}
 
public void setSubject(String subject) {
this.subject = subject;
}
}