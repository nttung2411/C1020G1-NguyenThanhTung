package com.example.service;


import com.example.model.SettingMail;
import com.example.repository.MailRepoImpl;
import com.example.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMailSettingImpl implements ServiceMailSetting{


    @Autowired
    MailRepository mailRepository;

    @Override
    public SettingMail createSettingMail() {
        return mailRepository.createSettingMail();
    }

    @Override
    public List<String> createLanguagesList() {
        return mailRepository.createLanguagesList();
    }

    @Override
    public List<Integer> createPageSizes() {
        return mailRepository.createPageSizesList();
    }

    @Override
    public SettingMail updateSettingMail(SettingMail newSetting) {
        return mailRepository.updateSettingMail(newSetting);
    }
}
