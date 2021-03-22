package com.example.demo.controllers;

import com.example.demo.models.employee.Employee;
import com.example.demo.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeeCreate")
    public String showCreateEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("listDivision",employeeService.findAllDivision());
        model.addAttribute("listPosition",employeeService.findAllPosition());
        model.addAttribute("listEducation",employeeService.findAllEducation());
        return "employee/create";
    }

    @PostMapping("/employeeCreate")
    public String createEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("listDivision",employeeService.findAllDivision());
            model.addAttribute("listPosition",employeeService.findAllPosition());
            model.addAttribute("listEducation",employeeService.findAllEducation());
            return "employee/create";
        }

        String checkDuplicate = employeeService.checkDuplicate(employee);
        if(checkDuplicate != null){
            model.addAttribute("messageDuplicate",checkDuplicate);
            model.addAttribute("listDivision",employeeService.findAllDivision());
            model.addAttribute("listPosition",employeeService.findAllPosition());
            model.addAttribute("listEducation",employeeService.findAllEducation());
            return "employee/create";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeList")
    public String showListEmployee(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("listEmployee",employeeService.findAllEmployee(pageable));
        return "employee/list";
    }

    @GetMapping("/employeeEdit{id}")
    public String showEditEmployee(@PathVariable String id , Model model){
        model.addAttribute("employee",employeeService.findById(id));
        model.addAttribute("listDivision",employeeService.findAllDivision());
        model.addAttribute("listPosition",employeeService.findAllPosition());
        model.addAttribute("listEducation",employeeService.findAllEducation());
        return "employee/edit";
    }

    @PostMapping("/employeeEdit")
    public String editEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult, Model model){
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
                return "redirect:/employeeList";
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
        return "redirect:/employeeList";
    }

    @GetMapping("/employee/delete")
    public String deleteEmployee(@RequestParam("idDelete") String id){
        employeeService.deleteEmployee(id);
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeSearch")
    public String searchCustomer(@RequestParam("nameEmployee") String name, Pageable pageable, Model model){
        model.addAttribute("listEmployee",employeeService.findEmployeeByName(pageable,name));
        return "employee/list";
    }
}
