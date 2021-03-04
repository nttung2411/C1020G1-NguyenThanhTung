//package com.example.demo.formatter;
//
//import com.example.demo.model.Province;
//import org.springframework.format.Formatter;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//public class ProvinceFormatter implements Formatter<Province> {
//    private ProvinceS provinceService;
//
//    public ProvinceFormatter(ProvinceService provinceService) {
//        this.provinceService = provinceService;
//    }
//
//    @Override
//    public Province parse(String text, Locale locale) throws ParseException {
//        return provinceService.(Long.valueOf(text));
//    }
//
//    @Override
//    public String print(Province object, Locale locale) {
//        return object.toString();
//    }
//}
