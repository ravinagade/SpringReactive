package com.spreactiveprg.spreactiveprg.controller;

import com.spreactiveprg.spreactiveprg.model.Employee;
import com.spreactiveprg.spreactiveprg.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/saveemployee")
    public Mono<Employee> saveEmployee(@RequestBody Employee employee){
        Mono<Employee> e=employeeRepo.save(employee);
        return e;
    }

    @GetMapping("/getemp")
    public Flux<Employee> getList(){

        return employeeRepo.findAll();
    }
}
