package com.bugtracking;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bugtracking.dao.AdminDao;
import com.bugtracking.dao.Employeedao;
import com.bugtracking.dao.ProjectDao;
import com.bugtracking.entity.AdminEntity;
import com.bugtracking.entity.EmployeeEntity;
import com.bugtracking.entity.ProjectEntity;
import com.bugtracking.exception.DuplicateRecordException;
import com.bugtracking.exception.InvalidDetailsException;
import com.bugtracking.exception.RecordNotFoundException;
import com.bugtracking.exception.RegistrationException;
import com.bugtracking.service.AdminServiceImpl;
import com.bugtracking.service.EmployeeServicesImpl;
import com.bugtracking.service.ProjectService;
import com.bugtracking.service.ProjectServiceImpl;

@SpringBootTest
class BugTrackingProjectUsingSpringBootApplicationTests {

	@MockBean
	AdminDao adminrepo;
	@Autowired
	AdminServiceImpl adminService;
	
	@MockBean
	Employeedao emprepo;
	@Autowired
	EmployeeServicesImpl empService;
	
	@MockBean
	ProjectDao dao;
	@Autowired 
	ProjectService service;
	
//Admin Part
	@Test
	public void testAddAdmin() throws RegistrationException, RecordNotFoundException {
		AdminEntity admin = new AdminEntity();// mock object
		admin.setMail("abcd@gmail.com");
		admin.setName("ABCD");
		admin.setContact("983948394");
		admin.setPassword("QWERTY");

		Mockito.doReturn(admin).when(adminrepo).save(admin);

		String result = adminService.createAdmin(admin);
		assertEquals("Admin Created Successfully", result);
	}

	
	@Test
	public void testviewAdmin() throws RecordNotFoundException {
		String email = "abcd@gmail.com";
		AdminEntity admin1 = new AdminEntity("abcd@gmail.com", "ABCD", "983948394", "QWERTY");
		AdminEntity admin = new AdminEntity();

		Mockito.when(adminrepo.findByMail(email)).thenReturn(admin1);
		admin = adminService.getByAdminId(email);

		assertEquals(admin1, admin);
	}
//Project Part	
	

	@Test
	void testAddProject() throws RegistrationException, RecordNotFoundException {
		ProjectEntity pro = new ProjectEntity();
		pro.setProjId((long)001);
		pro.setProjName("BugTracking");
		pro.setEmp_name("Ramesh");
		pro.setProjStatus("Active");
		
		Mockito.doReturn(pro).when(dao).save(pro);
		String result = service.addProject(pro);
		assertEquals("Project Inserted Successfully",result);
	}

	@Test
	void testDeleteProject() throws RegistrationException, RecordNotFoundException {
		ProjectEntity pro = new ProjectEntity();
		pro.setProjId((long)001);
		Mockito.doReturn(Optional.of(pro)).when(dao).findById(pro.getProjId());
		String result = service.deleteProject(pro.getProjId());
		assertEquals("Project Deleted Successfully", result);
	}

	@Test
	void testUpdateProject() throws RegistrationException, RecordNotFoundException {
		ProjectEntity pro = new ProjectEntity();
		pro.setProjId((long)001);
		pro.setProjName("BugTracking");
		pro.setEmp_name("Suresh");
		pro.setProjStatus("Active");
		
		Mockito.doReturn(pro).when(dao).save(pro);
		String result = service.updateProject(pro);
		assertEquals("Project Updated Successfully",result);
	}
	@Test
	public void getProject() throws RegistrationException, RecordNotFoundException {
		long projId = 123;
	    ProjectEntity proj = new ProjectEntity();
		proj.setProjId(123);
		proj.setProjName("DemoProject");
		proj.setEmp_name("DemoEmployee");
		proj.setProjStatus("Completed");

	    Mockito.when(dao.findById(projId)).thenReturn(Optional.of(proj));

	    Optional<ProjectEntity> result = Optional.of(service.getProject(projId));
	    assertTrue(result.isPresent());
	    assertEquals(proj, result.get());

	}
	@Test
	public void getAllProjects() throws RegistrationException, RecordNotFoundException {
		List<ProjectEntity> projects = new ArrayList<>();
	    ProjectEntity proj1 = new ProjectEntity();
	    proj1.setProjId(123);
		proj1.setProjName("DemoProject1");
		proj1.setEmp_name("DemoEmployee1");
		proj1.setProjStatus("Completed");
		Mockito.doReturn(proj1).when(dao).save(proj1);

	    
	    ProjectEntity proj2 = new ProjectEntity();
	    proj2.setProjId(456);
		proj2.setProjName("DemoProject2");
		proj2.setEmp_name("DemoEmployee2");
		proj2.setProjStatus("Completed");
		Mockito.doReturn(proj2).when(dao).save(proj2);	    
	    
		Mockito.doReturn(projects).when(dao).findAll();
	    
	    List<ProjectEntity> result = service.getAllProjects();
	    
	    assertEquals(projects.size(), result.size());
	    
	    assertTrue(result.containsAll(projects));
	}
	
//Employee Part
	@Test
	public void testAddEmployee() throws RegistrationException, RecordNotFoundException, DuplicateRecordException, InvalidDetailsException {
		EmployeeEntity emp = new EmployeeEntity();//mock object
		emp.setEmpNname("John");
		emp.setEmail("John@gmail.com");
		emp.setEmpContact("983948394");
		emp.setEpassword("900");
		emp.setProjectId((long) 1111);
		emp.setProject_name("demo");
		
	   Mockito.doReturn(emp).when(emprepo).save(emp);
	   
		String result = empService.createEmployee(emp);
			assertEquals("Employee Created Successfully",result);
	}
	
	@Test
	public void testUpdateEmployee() throws RegistrationException, RecordNotFoundException {
		EmployeeEntity emp = new EmployeeEntity();//mock object
		emp.setEmpNname("Jane");
		emp.setEmail("Jane@gmail.com");
		emp.setEmpContact("983948394");
		emp.setEpassword("900");
		emp.setProjectId((long) 1111);
		emp.setProject_name("demo");
		
	   Mockito.doReturn(emp).when(emprepo).save(emp);
	   
		String result = empService.updateEmployee(emp);
			assertEquals("Employee Updated Successfully",result);
	}
	
	@Test
	public void testDeleteEmployee() throws RegistrationException, RecordNotFoundException {
	    EmployeeEntity emp = new EmployeeEntity();
	    emp.setEmail("xyz@gmail.com"); 
	    
	    Mockito.doReturn(Optional.of(emp)).when(emprepo).findById(emp.getEmail());
	    
	    String result = empService.deleteEmployee(emp.getEmail());
	    
	    assertEquals("Employee Deleted Successfully", result);
	}
	
	@Test
	public void testGetEmployeeById() throws RegistrationException, RecordNotFoundException {
	    String email = "jane@gmail.com";
	    EmployeeEntity emp = new EmployeeEntity();
	    emp.setEmpNname("Jane");
	    emp.setEmail(email);
	    emp.setEmpContact("983948394");
	    emp.setEpassword("900");
	    emp.setProjectId((long) 1111);
	    emp.setProject_name("demo");

	    Mockito.when(emprepo.findById(email)).thenReturn(Optional.of(emp));

	    Optional<EmployeeEntity> result = empService.getEmployeeById(email);
	    assertTrue(result.isPresent());
	    assertEquals(emp, result.get());
	}

	
	@Test
	public void testGetAllEmployees() throws RegistrationException, RecordNotFoundException {
	    // Create a list of mock EmployeeEntity objects
	    List<EmployeeEntity> employees = new ArrayList<>();
	    EmployeeEntity emp1 = new EmployeeEntity();
	    emp1.setEmpNname("Jane");
		emp1.setEmail("Jane@gmail.com");
		emp1.setEmpContact("983948394");
		emp1.setEpassword("900");
		emp1.setProjectId((long) 1111);
		emp1.setProject_name("demo");
		Mockito.doReturn(emp1).when(emprepo).save(emp1);

	    
	    EmployeeEntity emp2 = new EmployeeEntity();
	    emp1.setEmpNname("John");
		emp1.setEmail("John@gmail.com");
		emp1.setEmpContact("983568394");
		emp1.setEpassword("800");
		emp1.setProjectId((long) 2222);
		emp1.setProject_name("demo2");
		Mockito.doReturn(emp2).when(emprepo).save(emp1);	    
	    // Mock the behavior of the EmployeeDao findAll() method to return the list of mock EmployeeEntity objects
	    Mockito.doReturn(employees).when(emprepo).findAll();
	    
	    // Call the getAllEmployees() method of the EmployeeService class and store the result
	    List<EmployeeEntity> result = empService.getAllEmployees();
	    
	    // Assert that the size of the result list is equal to the size of the mock list of EmployeeEntity objects
	    assertEquals(employees.size(), result.size());
	    
	    // Assert that the result list contains all of the mock EmployeeEntity objects
	    assertTrue(result.containsAll(employees));
	}

}
