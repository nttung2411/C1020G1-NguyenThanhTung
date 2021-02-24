package com.example.controllers;


import com.example.model.SettingMail;
import com.example.service.ServiceMailSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.repository.MailRepoImpl;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingMailController {

    @Autowired
    ServiceMailSetting serviceMailSetting;

    @RequestMapping("/")
    public String getPageSettingMail(Model model){
        model.addAttribute("settingMail",serviceMailSetting.createSettingMail());
        model.addAttribute("language",serviceMailSetting.createLanguagesList());
        model.addAttribute("pageSize",serviceMailSetting.createPageSizes());
        model.addAttribute("spamsFilter",serviceMailSetting.createSettingMail().isSpamsFilter());
        return "index";
    }

    @RequestMapping("/update")
    public String updateSettingMail(@ModelAttribute SettingMail settingMail, Model model){
        model.addAttribute("settingMail",serviceMailSetting.updateSettingMail(settingMail));
        model.addAttribute("language",serviceMailSetting.createLanguagesList());
        model.addAttribute("pageSize",serviceMailSetting.createPageSizes());
        model.addAttribute("spamsFilter",settingMail.isSpamsFilter());
        return "index";
    }


}
