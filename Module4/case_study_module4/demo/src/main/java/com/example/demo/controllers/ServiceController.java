package com.example.demo.controllers;

import com.example.demo.models.services.RentTypeService;
import com.example.demo.models.services.Service;
import com.example.demo.service.services_service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ServiceController {


    @Autowired
    ServicesService servicesService;

    @ModelAttribute("rentTypes")
    public List<RentTypeService> findAllRentType(){
        return servicesService.findAllRentType();
    }


    @GetMapping("/villa/create")
    public String showCreateVilla(Model model){
        model.addAttribute("villa",new Service());
        return "service/villa";
    }

    @PostMapping("/villa/create")
    public String createVilla(@Validated @ModelAttribute("villa") Service service, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "service/villa";
        }
        service.setTypeService(servicesService.findTypeServiceId(1));
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/house/create")
    public String showCreateHouse(Model model){
        model.addAttribute("house",new Service());
        return "service/house";
    }

    @PostMapping("/house/create")
    public String createHouse(@ModelAttribute("house") Service service, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "service/house";
        }
        service.setTypeService(servicesService.findTypeServiceId(2));
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/room/create")
    public String showCreateRoom(Model model){
        model.addAttribute("room",new Service());
        return "service/room";
    }

    @PostMapping("/room/create")
    public String createRoom(@ModelAttribute("room") Service service, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "service/room";
        }
        service.setTypeService(servicesService.findTypeServiceId(3));
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/service/list")
    public String showListService(Model model , @PageableDefault(size = 5)Pageable pageable){
        model.addAttribute("listService",servicesService.findAll(pageable));
        return "service/list";
    }

    @GetMapping("/service/edit/{id}")
    public String editService(@PathVariable String id,Model model){
        Service service = servicesService.findById(id);
        if(service.getTypeService().getServiceTypeName().equals("Villa")){
            model.addAttribute("villa",service);
            return "service/edit_villa";
        }
        if(service.getTypeService().getServiceTypeName().equals("House")){
            model.addAttribute("house",service);
            return "service/edit_house";
        }else {
            model.addAttribute("room",service);
            return "service/edit_room";
        }
    }

    @PostMapping("/villa/edit")
    public String editVilla(@Validated @ModelAttribute("villa") Service service, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("villa",service);
            return "service/edit_villa";
        }
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @PostMapping("/house/edit")
    public String editHouse(@Validated @ModelAttribute("house") Service service, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("house",service);
            return "service/edit_house";
        }
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @PostMapping("/room/edit")
    public String editRoom(@Validated @ModelAttribute("room") Service service, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("room",service);
            return "service/room";
        }
        servicesService.saveService(service);
        return "redirect:/service/list";
    }

    @GetMapping("/service/delete")
    public String deleteForm(@RequestParam String idDelete){
        servicesService.deleteById(idDelete);
        return "redirect:/service/list";
    }

    @GetMapping("/service/information/{id}")
    public String showInfo(@PathVariable String id,Model model){
        model.addAttribute("service",servicesService.findById(id));
        return "service/information_service";
    }
}
