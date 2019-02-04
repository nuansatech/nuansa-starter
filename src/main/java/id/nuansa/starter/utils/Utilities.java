package id.nuansa.starter.utils;

import id.nuansa.starter.constant.StatusCode;
import id.nuansa.starter.exception.AppException;
import org.springframework.http.HttpStatus;

public class Utilities {

    public static Integer toInt(String numberInString) {
        try {
            return Integer.parseInt(numberInString);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Boolean isValid(String text) {
        return null != text && !text.isEmpty();
    }

    public static Boolean convertToBoolean(String booleanInString) {
        if (booleanInString.equalsIgnoreCase("true"))
            return true;
        else if (booleanInString.equalsIgnoreCase("false"))
            return false;
        throw new AppException(booleanInString + " cannot convert to boolean type", StatusCode.ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
