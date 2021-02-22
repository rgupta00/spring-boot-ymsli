package com.javacodegeeks.examples.service;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Service;

import com.javacodegeeks.examples.model.Student;
import com.javacodegeeks.examples.repository.StudentRepository;

@Service
@Path("students")
public class StudentService {

	private final StudentRepository repository;
	 
	public StudentService(StudentRepository repository) {
	    this.repository = repository;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<Student> getStudents() {
	    return repository.findAll();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent(@PathParam("id") Long id) {
	    Student student = repository.findById(id).orElseThrow(NotFoundException::new);
	    return Response.ok(student).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student, @Context UriInfo uriInfo) throws URISyntaxException {
	    Student result = repository.save(student);
	    return Response.created(new URI(
	            String.format("%s/%s",uriInfo.getAbsolutePath().toString(), 
	            result.getId())))
	            .build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStudent(@PathParam("id") Long id, Student student) {
	    Student studentInDB = repository.findById(id).orElseThrow(NotFoundException::new);
	     
	    studentInDB.setFirstName(student.getFirstName());
	    studentInDB.setLastName(student.getLastName());
	    studentInDB.setYear(student.getYear());
	    repository.save(studentInDB);
	     
	    return Response.ok(studentInDB).build();        
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteStudent(@PathParam("id") Long id) {
	     repository.findById(id).orElseThrow(NotFoundException::new);
	     repository.deleteById(id);
	     return Response.ok().build();
	}
}
