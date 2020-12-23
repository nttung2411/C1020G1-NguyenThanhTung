package string_regex.bai_tap.validate_class;

public class TestValidateClass {
    public static void main(String[] args) {
        String testValidate1 = "A0202G";
        String testValidate2 = "B0002G";
        ValidateClass validateClass = new ValidateClass();

        System.out.println(validateClass.validateClass(testValidate1));

        System.out.println(validateClass.validateClass(testValidate2));
    }
}
