package com.javatechie.spring.rest.api.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.javatechie.spring.rest.api.dao.EmployeeDao;
import com.javatechie.spring.rest.api.model.Employee;

@Path("/employeeResource")
public class EmployeeResource {
	
	@Autowired
	private EmployeeDao dao;
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/save")
	public Employee saveEmployee(Employee employee) {
		return dao.save(employee);
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getAllEmployees")
	public List<Employee> getAllEMployees(){
		return dao.findAll();	
	}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getEmployee/{name}")
	public Employee getEmployeeByName(@PathParam("name") String name) {
		return dao.findByName(name);
	}

}
