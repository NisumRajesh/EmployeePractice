package com.nisum;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.nisum.Dao;

@Controller
public class HelloController {
  
	@Autowired
	Dao daoo;

	@RequestMapping("/register")
	public ModelAndView mymethod() {
		return new ModelAndView("register","emp",new Employee());  
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	 public ModelAndView adduser(@ModelAttribute("emp") Employee emp){  
      daoo.save(emp);
		
		return new ModelAndView("redirect:/viewemp");
	}
	@RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Employee> list=daoo.getEmployees();  
        return new ModelAndView("viewemp","list",list);  
    }  
	@RequestMapping(value="/editemp/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Employee emp=daoo.getEmpById(id);  
        return new ModelAndView("empeditform","command",emp);  
    }  
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        daoo.delete(id);  
        return new ModelAndView("redirect:/viewemp");  
    }  
	@RequestMapping(value="/update",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("emp") Employee emp){  
        daoo.update(emp);  
        return new ModelAndView("redirect:/viewemp");  
    }  
}
