package org.example.components.empolyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final MyEmployeeRepository myEmployeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, MyEmployeeRepository myEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.myEmployeeRepository = myEmployeeRepository;
    }

    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    public Iterable<Employee> filter(String name, String email, String phone, Double salary, String position){
        return myEmployeeRepository.filter(name, email, phone, salary, position);
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }
}
