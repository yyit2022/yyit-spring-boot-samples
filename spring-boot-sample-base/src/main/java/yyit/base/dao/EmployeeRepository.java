package yyit.base.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import yyit.base.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}