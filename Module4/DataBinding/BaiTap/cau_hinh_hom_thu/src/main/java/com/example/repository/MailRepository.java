package com.example.repository;

import com.example.model.SettingMail;

import java.util.List;
import java.util.Set;

public interface MailRepository {
    SettingMail createSettingMail();
    List<String> createLanguagesList();
    List<Integer> createPageSizesList();
    SettingMail updateSettingMail(SettingMail newSetting);
}
