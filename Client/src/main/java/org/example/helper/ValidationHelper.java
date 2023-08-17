package org.example.helper;

import java.util.Objects;

public class ValidationHelper {
    public static <T> boolean checkNotNull(T obj) {
        return (obj != null);
    }

    public static <T extends Number> boolean checkNumberPositivity(T obj) {
        return (obj.doubleValue() > 0.0D);
    }

    public static boolean checkStringNotEmpty(String obj) {
        return (!Objects.equals(obj, ""));
    }

    public static boolean checkStringSize(String obj, int size) {
        return (obj.length() <= size);
    }
    public static boolean checkPassportIdLength(String passportId) {
        return passportId.length() >= 6;
    }

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String s){
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
