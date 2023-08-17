package org.example.collectionLogicModule.util.helper;

public class XmlValidationHelper {
    public static <T> void checkNotNullXml(T obj, String message){
        if(obj == null){
            throw new RuntimeException(message);
        }
    }
    public static <T extends Number> void checkNumberPositivityXml (T obj, String message){
        if(obj.doubleValue() <= 0){
            throw new RuntimeException(message);
        }
    }
    public static void checkStringNotEmptyXml (String obj, String message) {
        if(obj.equals("")){
            throw new RuntimeException(message);
        }
    }
    public static void checkStringSizeXml (String obj, int size,  String message){
        if(obj.length() > size){
            throw new RuntimeException(message);
        }
    }
}
