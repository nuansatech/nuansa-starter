package id.nuansa.starter.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date toDate(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(stringDate);
        } catch (Exception e) {
            return null;
        }
    }
}
