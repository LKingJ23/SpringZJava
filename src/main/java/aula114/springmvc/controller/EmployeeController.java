package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import aula114.springmvc.service.EmployeeService;
import aula114.springmvc.domain.Contact;

import java.util.List;
import java.util.ArrayList;

@Controller
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("/employee")
  public String consultaEmployee(Model model) {
     List<Contact> list = new ArrayList<Contact>();
     //List<String> list = new ArrayList<String>();
     //list = employeeService.listIdEmployee();
     list = employeeService.listAllEmployee();
     model.addAttribute("list", list);
     System.out.println("tttttttttttt");
     System.out.println(list.get(0).getName());
     System.out.println("tttttttttttt");
     return "consulta";
  }

/*
  @RequestMapping("/show")
  public String consultaEmployee(Model model) {
     List<Contact> list = new ArrayList<Contact>();
     list = employeeService.listAllEmployee();
     model.addAttribute("list", list);
     return "consulta2";
  }*/

  @RequestMapping("/show", method=RequestMethod.GET)
  public String showData(@RequestParam("email") String email){
    List<Contact> list = new ArrayList<Contact>():
    list = employeeService.listAllEmployee();
    for(int i=0;i<list.length;i++){
      if(list[i].getEmail() == email){
        c = new Contact(list[i].getName, list[i].getEmail, list[i].getAddress, list[i].getTelephone);
        model.addAttribute("c", contact);
      }
    }
    return "consulta2";
  }

}
