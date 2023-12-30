package validate;

public class InputRegex {
    public static boolean isPhoneNumber(String phone) {
        String regex = "^(0|\\+84)\\d{9}$";
        if (phone.matches(regex)) {
            return true;
        }
        return false;
    }
    public static boolean isEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email.matches(regex)) {
            return true;
        }
        return false;
    }
}
