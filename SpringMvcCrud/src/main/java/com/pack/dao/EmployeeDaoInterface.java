package com.pack.dao;

import java.util.List;

import com.pack.model.Employee;

public interface EmployeeDaoInterface {
	
	
    public int insert(Employee e);
    
    List<Employee> viewAll();
    
    Employee getEmpById(int id);
    
    int modify(Employee e);
    
    public int delete(int id);
}
