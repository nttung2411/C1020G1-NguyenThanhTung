package common;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCustomer {
    //    private static final String REGEX_NAME_CUSTOMER = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ]+[a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểếễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*)+$";
    private static final String REGEX_NAME_CUSTOMER = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}$";
    private static final String REGEX_EMAIL_CUSTOMER = "^[a-z]+@[a-z]+([.][a-z]{2,})+$";
    private static final String REGEX_GENDER_CUSTOMER = "^(Female|Male|Unknown)$";
    private static final String REGEX_ID_CARD = "^[0-9]{3}[-][0-9]{3}[-][0-9]{3}$";
    private static final String REGEX_BIRTHDAY_CUSTOMER = "^\\d{2}[/]\\d{2}[/]\\d{4}$";
    private static final String REGEX_PHONE_CUSTOMER = "^[0][0-9]{3}[-][0-9]{3}[-][0-9]{3}$";
    private static final String REGEX_CARD_CUSTOMER = "(Diamond|Platinum|Gold|Silver|Member)";

    public static boolean validateName(String regex) {
        Pattern pattern = Pattern.compile(REGEX_NAME_CUSTOMER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL_CUSTOMER);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateIdCard(String regex) {
        Pattern pattern = Pattern.compile(REGEX_ID_CARD);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static String validateGender(String regex) {
        StringBuilder stringGender = new StringBuilder(regex.toLowerCase());
        String newUpperChar = String.valueOf(stringGender.charAt(0)).toUpperCase();
        stringGender.replace(0, 1, newUpperChar);
        regex = stringGender.toString();

        if (regex.matches(REGEX_GENDER_CUSTOMER)) {
            return regex;
        } else {
            return null;
        }
    }

    public static boolean validatePhoneNumber(String regex) {
        return regex.matches(REGEX_PHONE_CUSTOMER);
    }

    public static String validateCardCustomer(String regex) {
        StringBuilder stringCardCustomer = new StringBuilder(regex.toLowerCase());
        String newUpperChar = String.valueOf(stringCardCustomer.charAt(0)).toUpperCase();
        stringCardCustomer.replace(0, 1, newUpperChar);
        regex = stringCardCustomer.toString();

        if (regex.matches(REGEX_CARD_CUSTOMER)) {
            return regex;
        } else {
            return null;
        }
    }

    public static boolean validateBirthDay(String regex) {
        //Lấy năm hiện tại!!
        Calendar calendar = Calendar.getInstance();
        int yearNow = calendar.get(Calendar.YEAR);

        Pattern pattern = Pattern.compile(REGEX_BIRTHDAY_CUSTOMER);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            String[] array = regex.split("/");
            if (Integer.parseInt(array[0]) > 31 || Integer.parseInt(array[1]) > 12 || Integer.parseInt(array[2]) < 1901 || Integer.parseInt(array[2]) > yearNow) {
                return false;
            } else if (Integer.parseInt(array[1]) == 2) {
                if (Integer.parseInt(array[2]) % 4 == 0 && Integer.parseInt(array[0]) > 29) {
                    return false;
                } else if (Integer.parseInt(array[2]) % 4 != 0 && Integer.parseInt(array[0]) > 28) {
                    return false;
                } else {
                    return true;
                }
            } else if (checkDate(Integer.parseInt(array[1])) && Integer.parseInt(array[0]) > 31) {
                return false;
            } else if (!checkDate(Integer.parseInt(array[1])) && Integer.parseInt(array[0]) > 30) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean checkDate(int Month) {
        switch (Month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return true;
            default:
                return false;
        }
    }
}
