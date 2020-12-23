package string_regex.thuc_hanh.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String ACCOUNT_REGEX = "^[_a-z0-9]{6,}$";

    public ValidateAccount() {
    }

    public boolean validateAccount(String regex){
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
