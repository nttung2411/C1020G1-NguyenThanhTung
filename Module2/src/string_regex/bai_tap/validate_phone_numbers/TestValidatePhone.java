package string_regex.bai_tap.validate_phone_numbers;

public class TestValidatePhone {
    public static void main(String[] args) {
        String phoneNumber = "(84)-(0978489648)";
        String phoneNumber2 = "(a8)-(22222222)";

        ValidatePhoneNumbers validatePhoneNumbers = new ValidatePhoneNumbers();
        System.out.println(validatePhoneNumbers.validatePhone(phoneNumber));
        System.out.println(validatePhoneNumbers.validatePhone(phoneNumber2));
    }
}
