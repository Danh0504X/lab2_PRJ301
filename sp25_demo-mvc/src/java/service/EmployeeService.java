/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Employee;

/**
 *
 * @author ADMIN
 */
public interface EmployeeService {
    
    List<Employee> findAll();
    void save(Employee customer);
    Employee findById(int id);
    void update(Employee customer);
    void remove(int id);

}
