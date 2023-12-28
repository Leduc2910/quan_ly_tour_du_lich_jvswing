package validate;

import java.text.NumberFormat;
import java.util.Locale;

public class InputValidate {
    public static String formatCurrency(double amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return numberFormat.format(amount);
    }
}
