package org.example.helper;

import org.example.entity.*;

import java.util.Scanner;

public class InputHelper {
    public static MusicBandDTO bandInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put band name");
        String bandName = scanner.nextLine();
        while(!ValidationHelper.checkStringNotEmpty(bandName)){
            System.out.println("Band name cant be an empty string");
            System.out.println("Put another band name");
            bandName = scanner.nextLine();
        }

        CoordinatesDTO bandCoord = coordinatesInput();

        System.out.println("Put number of participants");
        String numberOfParticipantsString = scanner.nextLine();
        while(!(ValidationHelper.isLong(numberOfParticipantsString)
                && ValidationHelper.checkNumberPositivity(Long.valueOf(numberOfParticipantsString)))){
            System.out.println("Number of participants must be Long and positive");
            System.out.println("Put another number of participants");
            numberOfParticipantsString = scanner.nextLine();
        }
        Long numberOfParticipants = Long.valueOf(numberOfParticipantsString);

        System.out.println("""
                Select music genre:
                1.Psychedelic cloud rap
                2.Jazz
                3.Soul
                4.Blues
                5.null
                """);
        String genre;
        switch (scanner.nextLine()){
            case "1" -> genre = "PSYCHEDELIC_CLOUD_RAP";
            case "2" -> genre = "JAZZ";
            case "3" -> genre = "SOUL";
            case "4" -> genre = "BLUES";
            default -> genre = null;
        }

        PersonDTO frontMan = personInput();

        return new MusicBandDTO(bandName,bandCoord,numberOfParticipants,genre,frontMan);
    }

    public static PersonDTO personInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put FrontMan name");
        String frontManName = scanner.nextLine();
        while (!ValidationHelper.checkStringNotEmpty(frontManName)) {
            System.out.println("FrontMan name is empty");
            System.out.println("Put another FrontMan name");
            frontManName = scanner.nextLine();
        }

        System.out.println("Put height");
        String heightString = scanner.nextLine();
        while(!(ValidationHelper.isFloat(heightString)
                && ValidationHelper.checkNumberPositivity(Float.valueOf(heightString)))){
            System.out.println("Height must be a positive float");
            System.out.println("Put another height");
            heightString = scanner.nextLine();
        }
        Float height = Float.valueOf(heightString);

        System.out.println("Put weight");
        String weightString = scanner.nextLine();
        while(!(ValidationHelper.isFloat(weightString)
                && ValidationHelper.checkNumberPositivity(Float.valueOf(weightString)))){
            System.out.println("Weight must be a positive float");
            System.out.println("Put another weight");
            weightString = scanner.nextLine();
        }
        float weight = Float.parseFloat(weightString);

        System.out.println("Put passport ID");
        String passportId = scanner.nextLine();
        while (!ValidationHelper.checkPassportIdLength(passportId)){
            System.out.println("Passport ID must be longer then 6 chars");
            System.out.println("Put another passport ID");
            passportId = scanner.nextLine();
        }

        LocationDTO location = locationInput();

        return new PersonDTO(frontManName,height,weight,passportId,location);
    }

    public static CoordinatesDTO coordinatesInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put x coord");
        String xCoordString = scanner.nextLine();
        while (!ValidationHelper.isInteger(xCoordString)) {
            System.out.println("x coord must be an integer");
            System.out.println("Put another x coord");
            xCoordString = scanner.nextLine();
        }
        Integer xCoord = Integer.valueOf(xCoordString);

        System.out.println("Put y coord");
        String yCoordString = scanner.nextLine();
        while (!ValidationHelper.isLong(yCoordString)) {
            System.out.println("x coord must be a long");
            System.out.println("Put another x coord");
            yCoordString = scanner.nextLine();
        }
        Long yCoord = Long.valueOf(xCoordString);

        return new CoordinatesDTO(xCoord, yCoord);
    }

    public static LocationDTO locationInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put location name");
        String locationName = scanner.nextLine();
        while(!ValidationHelper.checkStringSize(locationName, 629)){
            System.out.println("Location name must be shorter than 630 letters");
            System.out.println("Put another location name");
            locationName = scanner.nextLine();
        }
        if (locationName.equals("")){
            locationName = null;
        }

        System.out.println("Put x coord");
        String xCoordString = scanner.nextLine();
        while (!ValidationHelper.isFloat(xCoordString)){
            System.out.println("x coord must be a float");
            System.out.println("Put another x coord");
            xCoordString = scanner.nextLine();
        }
        Float xCoord = Float.valueOf(xCoordString);

        System.out.println("Put y coord");
        String yCoordString = scanner.nextLine();
        while (!ValidationHelper.isInteger(yCoordString)) {
            System.out.println("y coord must be an integer");
            System.out.println("Put another y coord");
            yCoordString = scanner.nextLine();
        }
        Integer yCoord = Integer.valueOf(yCoordString);

        System.out.println("Put z coord");
        String zCoordString = scanner.nextLine();
        while (!ValidationHelper.isDouble(zCoordString)) {
            System.out.println("z coord must be a double");
            System.out.println("Put another z coord");
            zCoordString = scanner.nextLine();
        }
        double zCoord = Double.parseDouble(yCoordString);

        return new LocationDTO(xCoord, yCoord, zCoord, locationName);
    }

    public static String idInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put band ID");
        String id = scanner.nextLine();
        while(!ValidationHelper.isInteger(id)){
            System.out.println("Band ID must be an integer");
            System.out.println("Put another band ID");
            id = scanner.nextLine();
        }

        return id;
    }

    public static String filenameInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Put full file path");
        String filePath = scanner.nextLine();
        while(!ValidationHelper.checkStringNotEmpty(filePath)){
            System.out.println("Filepath cannot be empty");
            System.out.println("Put another full filepath");
            filePath = scanner.nextLine();
        }

        return filePath;
    }
}
