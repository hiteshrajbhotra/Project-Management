-- INSERT PROJECTS			
insert into project (project_id, name, stage, description) values (1000, 'Large Production Deploy', 'NOTSTARTED', 'This requires all hands on deck for the final deployment of the software into production');
insert into project (project_id, name, stage, description) values (1001, 'New Employee Budget',  'COMPLETED', 'Decide on a new employee bonus budget for the year and figureout who will be promoted');
insert into project (project_id, name, stage, description) values (1002, 'Office Reconstruction', 'INPROGRESS', 'The office building in Monroe has been damaged due to hurricane in the region. This needs to be reconstructed');
insert into project (project_id, name, stage, description) values (1003, 'Improve Intranet Security', 'INPROGRESS', 'With the recent data hack, the office security needs to be improved and proper security team needs to be hired for implementation');

-- INSERT EMPLOYEEs			
insert into employee (employee_id, emp_name,is_employeed, email) values (1, 'John', 'Yes','warton@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (2, 'Mike','Yes','lanister@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (3, 'Steve','Yes','Reeves@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (4, 'Connor','Yes', 'connor@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (5, 'Salvator','Yes', 'Sal@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (6, 'Henley','Yes', 'henley@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (7, 'Carson','Yes', 'carson@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (8, 'Miles','Yes', 'miles@gmail.com');
insert into employee (employee_id, emp_name,is_employeed, email) values (9, 'Roggers','Yes', 'roggers@gmail.com');

-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into project_employee (employee_id, project_id) values (1,1000);
insert into project_employee (employee_id, project_id) values (1,1001);
insert into project_employee (employee_id, project_id) values (1,1002);
insert into project_employee (employee_id, project_id) values (3,1000);
insert into project_employee (employee_id, project_id) values (6,1002);
insert into project_employee (employee_id, project_id) values (6,1003);
													