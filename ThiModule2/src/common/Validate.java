package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String NAME_REGEX = "^[A-Z][a-z]{2,10}$";
    private static final String PHAMVI_REGEX = "(Toan Quoc|Quoc Te)";
    private static final String QUOCGIA_REGEX = "(Trung Quoc|My|Han Quoc|Nhat Ban)";
    private static final String TRANGTHAI_REGEX = "(Da sua chua|Chua sua chua)";

    public static boolean validateNameMobile(String regex){
        return regex.matches(NAME_REGEX);
    }

    public static boolean validatePhamViBaoHanh(String regex){
        return regex.matches(PHAMVI_REGEX);
    }

    public static boolean validateQuocGia(String regex){
        return regex.matches(QUOCGIA_REGEX);
    }

    public static boolean validateTrangThai(String regex){
        return regex.matches(TRANGTHAI_REGEX);
    }
}
