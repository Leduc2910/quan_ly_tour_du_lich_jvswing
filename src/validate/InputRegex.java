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
    public static boolean isBirthday(String birthday) {
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        if (birthday.matches(regex)) {
            return true;
        }
        return false;
    }
}
