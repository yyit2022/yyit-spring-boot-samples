package yyit.base.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import yyit.base.domain.Employee;
import yyit.base.events.EmailEvent;
import yyit.base.publisher.EmailPublisher;
import yyit.base.services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmailPublisher emailPublisher;

    @GetMapping("/notify/event")
    public void publishEvent(){
        emailPublisher
                .publishEmailEvent
                    (new EmailEvent("Employee added."));

        emailPublisher
                .publishMsgEvent
                        ("Exception occurred.");
    }

    @Autowired
    EmployeeService employeeService;
  
    @PostMapping("/employee")
    Employee create(@RequestBody Employee employee)  {
      return employeeService.save(employee);
    }
  
    @GetMapping("/employee")
    Iterable<Employee> read() {
      return employeeService.findAll();
    }
  
    @PutMapping("/employee")
    Employee update(@RequestBody Employee employee) {
      return employeeService.save(employee);
    }
  
    @DeleteMapping("/employee/{id}")
    void delete(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }
  
    @GetMapping("/wrong")
    Employee somethingIsWrong() {
      throw new ValidationException("Something is wrong");
    }
  
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    String exceptionHandler(ValidationException e) {
      return e.getMessage();
    }
}