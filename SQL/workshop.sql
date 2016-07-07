select * from employees;
select * from departments;
select * from jobs;
select first_name from employees;

select * from employees
where department_id = 50;

update employees
set salary = 1.3 * salary where department_id = 50;

update employees
set manager_id = null where manager_id = 101;
delete from employees where employee_id = 101;

select * from employees
where job_id = 'IT_PROG'
order by first_name;

select count(employee_id) from employees emp
where emp.job_id = 'IT_PROG';

select emp.*, dept.department_name
from employees emp, departments dept
where emp.department_id = dept.department_id and emp.department_id = 50;

select *
from employees natural join departments
where location_id = 1700;

create VIEW employee_view AS
  SELECT e.employee_id, e.first_name, d.department_name
  FROM employees e, departments d
  WHERE e.department_id = d.department_id;
  
select sysdate from dual;
select to_char(sysdate, 'dd-MM-yyyy') from dual;
select to_date('25-11-2014', 'dd-MM-yyyy') from dual;

select upper(first_name), lower(email)
from employees;

select 'First Name: ' || first_name
from employees;

select count(*) from employees;

select count(*) from employees where job_id = 'IT_PROG';

select count(*) from employees group by department_id;

select avg(salary) from employees where department_id = 50;

select max(e.salary) max_salary, min(e.salary) min_salary
from employees e, departments d
where e.department_id = d.department_id
  and d.location_id = (select location_id from locations where city = 'Seattle');
  
commit;