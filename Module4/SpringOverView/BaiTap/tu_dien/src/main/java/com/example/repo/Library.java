package com.example.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements RepoLibrary{
    @Override
    public String translate(String word) {
        Map<String,String> library = new HashMap<>();
        library.put("hello","Xin chào");
        library.put("good","Tốt");
        library.put("perfect","Tuyệt vời");
        library.put("never","Không bao giờ");
        library.put("Spring","Mùa xuân");

        for (Map.Entry<String,String> entry : library.entrySet()){
            if(entry.getKey().equals(word.toLowerCase())){
                return entry.getValue();
            }
        }

        return "Không tìm thấy";
    }
}
