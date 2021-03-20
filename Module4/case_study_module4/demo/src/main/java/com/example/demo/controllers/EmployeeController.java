package com.example.demo.controllers;

import com.example.demo.models.employee.Employee;
import com.example.demo.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/create")
    public String showCreateEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("listDivision",employeeService.findAllDivision());
        model.addAttribute("listPosition",employeeService.findAllPosition());
        model.addAttribute("listEducation",employeeService.findAllEducation());
        return "employee/create";
    }

    @PostMapping("/employee/create")
    public String createEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("listDivision",employeeService.findAllDivision());
            model.addAttribute("listPosition",employeeService.findAllPosition());
            model.addAttribute("listEducation",employeeService.findAllEducation());
            return "employee/create";
        }

        String checkDuplicate = employeeService.checkDuplicate(employee);
        if(checkDuplicate != null){
            model.addAttribute("messageDuplicate",checkDuplicate);
            return "employee/create";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/list")
    public String showListEmployee(Model model, @PageableDefault(size = 5)Pageable pageable){
        model.addAttribute("listEmployee",employeeService.findAllEmployee(pageable));
        return "employee/list";
    }

    @GetMapping("/employee/edit/{id}")
    public String showEditEmployee(@PathVariable String id , Model model){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("listDivision",employeeService.findAllDivision());
        model.addAttribute("listPosition",employeeService.findAllPosition());
        model.addAttribute("listEducation",employeeService.findAllEducation());
        return "employee/edit";
    }

    @PostMapping("/employee/edit")
    public String editEmployee(@Validated @ModelAttribute Employee employee,BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("listDivision",employeeService.findAllDivision());
            model.addAttribute("listPosition",employeeService.findAllPosition());
            model.addAttribute("listEducation",employeeService.findAllEducation());
            return "employee/edit";
        }

        String checkDuplicate = employeeService.checkDuplicate(employee);
        Employee employee2 = employeeService.findById(employee.getEmployeeId());
        if(checkDuplicate != null){
            if(employee.getEmployeeEmail().equals(employee2.getEmployeeEmail())){
                employeeService.editEmployee(employee);
                return "redirect:/employee/list";
            }else if(checkDuplicate.equals("Email đã tồn tại")) {
                model.addAttribute("employee",employee);
                model.addAttribute("listDivision",employeeService.findAllDivision());
                model.addAttribute("listPosition",employeeService.findAllPosition());
                model.addAttribute("listEducation",employeeService.findAllEducation());
                model.addAttribute("messageDuplicate",checkDuplicate);
                return "employee/edit";
            }
        }

        employeeService.editEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("idDelete") String id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/employee/search")
    public String searchCustomer(@RequestParam("nameEmployee") String name,Pageable pageable,Model model){
        model.addAttribute("listEmployee",employeeService.findEmployeeByName(pageable,name));
        return "employee/list";
    }
}
