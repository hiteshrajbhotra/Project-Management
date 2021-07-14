package com.hit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hit.dto.EmployeeProject;
import com.hit.entities.Employee;

public interface EmployeeDoa extends CrudRepository<Employee, Long>{
	
	@Override
	List<Employee> findAll();
	
	@Query(nativeQuery=true,value = "select e.emp_name as empName,e.email email,count(project_id) as projCount from employee e "
			+ " inner join project_employee pe on(pe.employee_id = e.employee_id) "
			+ "	group by e.emp_name,e.email order by projCount;")
	List<EmployeeProject> getEmployeeProjectDtls();

}
