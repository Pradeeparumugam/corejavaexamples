package com.dxctraining.ui;

import com.dxctraining.entities.Employee;
import com.dxctraining.exceptions.EmployeeNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployeeUi {
    @Autowired
    private IEmployeeService service;


    @PostConstruct
    public void runUi(){
        try {
            Employee employee1 = new Employee("vineel", 21, 5000);
            Employee employee2 = new Employee("khadar", 22, 3000);
            employee1 = service.save(employee1);
            employee2 = service.save(employee2);

            int id1 = employee1.getId();
            Employee fetched = service.findEmployeeById(id1);
            System.out.println("fetcehd employee =" + fetched.getName() + " " + fetched.getAge() + " " + fetched.getSalary());
        }catch (EmployeeNotFoundException e){
            e.printStackTrace();
        }

        catch (InvalidArgumentException e){
            e.printStackTrace();
        }
    }



}