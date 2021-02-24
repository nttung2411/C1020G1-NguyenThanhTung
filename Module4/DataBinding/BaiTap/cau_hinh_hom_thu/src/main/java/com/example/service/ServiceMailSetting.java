package com.example.service;

import com.example.model.SettingMail;

import java.util.List;
import java.util.Set;

public interface ServiceMailSetting {
    SettingMail createSettingMail();
    List<String> createLanguagesList();
    List<Integer> createPageSizes();
    SettingMail updateSettingMail(SettingMail newSetting);
}
