package string_regex.bai_tap.validate_phone_numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumbers {
    private static final String PHONE_REGEX = "^[(]\\d{2,}[)][-][(][0]\\d{9,}[)]$";

    public ValidatePhoneNumbers() {
    }

    public boolean validatePhone(String regex){
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
