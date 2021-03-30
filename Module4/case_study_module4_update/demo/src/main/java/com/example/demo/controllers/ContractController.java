package com.example.demo.controllers;

import com.example.demo.models.contract.AttachService;
import com.example.demo.models.contract.Contract;
import com.example.demo.models.contract.ContractDetail;
import com.example.demo.service.contract_service.ContractService;
import com.example.demo.service.customer_service.CustomerService;
import com.example.demo.service.employee_service.EmployeeService;
import com.example.demo.service.services_service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContractController{

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ServicesService servicesService;


    @ModelAttribute("attachServices")
    public List<AttachService> findAllAttachService(){
        return contractService.findAllAttachService();
    }

    @GetMapping("/contractCreate")
    public String showCreateContract(Model model, Pageable pageable){
        model.addAttribute("contract",new Contract());
        model.addAttribute("listCustomer",customerService.findAll(pageable));
        model.addAttribute("listEmployee",employeeService.findAllEmployee(pageable));
        model.addAttribute("listService",servicesService.findAll(pageable));
        return "contract/create";
    }

    @PostMapping("/contractCreate")
    public String createContract(@ModelAttribute Contract contract){
        contractService.createContract(contract);
        return "redirect:/contractList";
    }

    @GetMapping("/contractList")
    public String listContract(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("listContract",contractService.findAll(pageable));
        return "contract/list";
    }

    @GetMapping("/contractSearch")
    public String searchContract(@RequestParam String search, RedirectAttributes redirectAttributes, @PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Contract> contracts = contractService.findContract(search,pageable);
        System.out.println(search);
        if(contracts.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Không tìm thấy");
            return "redirect:/contractList";
        }
        model.addAttribute("listContract",contracts);
        return "contract/list";
    }

    @GetMapping("/contractdetailCreate")
    public String showCreateContractDetail(Model model , Pageable pageable){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("listContract",contractService.findAll(pageable));
        return "contract/create_contract_detail";
    }

    @PostMapping("/contractdetailCreate")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail){
        contractService.createContractDetail(contractDetail);
        return "redirect:/contractList";
    }
}
