package com.example.repository;


import com.example.model.SettingMail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MailRepoImpl implements MailRepository{
    SettingMail settingMail = new SettingMail();

    @Override
    public SettingMail createSettingMail() {
        return settingMail;
    }

    @Override
    public List<String> createLanguagesList() {
        List<String> languagesList = new ArrayList<>();
        languagesList.add("Japanese");
        languagesList.add("Vietnamese");
        languagesList.add("Chinese");
        languagesList.add("English");
        return languagesList;
    }

    @Override
    public List<Integer> createPageSizesList() {
        List<Integer> pageSizesList = new ArrayList<>();
        pageSizesList.add(5);
        pageSizesList.add(10);
        pageSizesList.add(15);
        pageSizesList.add(25);
        pageSizesList.add(50);
        pageSizesList.add(100);
        return pageSizesList;
    }

    @Override
    public SettingMail updateSettingMail(SettingMail newSetting) {
        settingMail.setLanguages(newSetting.getLanguages());
        settingMail.setPageSize(newSetting.getPageSize());
        settingMail.setSpamsFilter(newSetting.isSpamsFilter());
        settingMail.setSignature(newSetting.getSignature());
        return settingMail;
    }
}