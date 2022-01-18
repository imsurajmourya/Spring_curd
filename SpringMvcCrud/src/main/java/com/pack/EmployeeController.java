package com.pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.pack.dao.EmployeeDao;
import com.pack.model.Employee;



@Controller
public class EmployeeController {
	
	 @Autowired 
		    EmployeeDao employeeDao;
	
	 
			
	 @RequestMapping("/") 
	 public String home() {
			  
	return "index"; 
	}
			 
	
	@RequestMapping("/addUserForm")  
	public String add(Model m)  
	{  
     m.addAttribute("emp", new  Employee());  
     return "userForm";  
	}
	
	
	  @RequestMapping(value = "/addEmployee", method = RequestMethod.POST) 
	  public String addStudent(Employee employee) {
		 int res= employeeDao.insert(employee);
		 if (res>=1)
		  return "redirect:/viewForm";
		 else
			 return "adduser-error";
	   
	  }
	 
	  
	
	  @RequestMapping("/viewForm")    
	    public String viewemp(Model m){    
	        List<Employee> list=employeeDao.viewAll();  
	        m.addAttribute("list",list);  
	        return "view";    
	    }  
	  
	  
		
		@RequestMapping("/editEmp")  
	    public String edit( @RequestParam("id") int ide, Model m){    
			 
		Employee emp=employeeDao.getEmpById(ide);
		m.addAttribute("editEmpForm",emp);
			 
			System.out.println("id "+ide);
			 
	        return "editAction";    
	    } 
		
		
		@RequestMapping("/editEmployee")
		public String modify(Employee employee)
		{
			int res=employeeDao.modify(employee);
			if (res>=1)
				  return "redirect:/viewForm";
				 else
					 return "adduser-error";
			  			 
		}
		
		 @RequestMapping(value="/deleteEmp/{ide}",method = RequestMethod.GET)
		  public  String delete(@PathVariable int ide){
			  int res=employeeDao.delete(ide);
			  if  (res>=1) return "redirect:/viewForm"; 
			  else
				  return "adduser-error";
		  
		  }
		
		 
}

