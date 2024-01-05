package validate;

import java.text.NumberFormat;
import java.util.Locale;

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

    public static String formatCurrency(int amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return numberFormat.format(amount);
    }

    public static boolean inputNumber(String value) {
        String regexInteger = "^[0-9]+$";
        if (value.matches(regexInteger)) {
            return true;
        }
        return false;
    }

    public static boolean isBirthday(String birthday) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d\\d$";
        if (birthday.matches(regex)) {
            return true;
        }
        return false;
    }
}
