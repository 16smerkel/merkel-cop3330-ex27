import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String theFirst = scanner.nextLine();
        System.out.println("Enter the last name:");
        String theLast = scanner.nextLine();
        System.out.println("Enter the ZIP code:");
        String theZIP = scanner.nextLine();
        System.out.println("Enter an employee ID:");
        String theID = scanner.nextLine();
        validateInput(theFirst, theLast, theZIP, theID);
    }

    public static void validateInput(String firstName, String lastName, String theZip, String theId)
    {
        int firstCheck = validateFirst(firstName);
        int lastCheck = validateLast(lastName);
        int zipCheck = validateZip(theZip);
        int idCheck = validateID(theId);
        if ( firstCheck * lastCheck * zipCheck * idCheck != 0)
        {
            System.out.println("There were no errors found.");
        }
    }

    public static int validateFirst(String firstName)
    {
        if(firstName.length() == 0)
        {
            System.out.println("The first name must be filled in.");
            return 0;
        }
        if(firstName.length() == 1)
        {
            System.out.println('"' + firstName + '"' + " is not a valid first name. It is too short.");
            return 0;
        }
        for (int i = 0; i < firstName.length(); i++) {
            char theOne = firstName.charAt(i);
            if (!Character.isAlphabetic(theOne)) {
                System.out.println("The first name should not have numbers.");
                return 0;
            }
        }
        return 1;
    }
    public static int validateLast(String lastName) {
        if (lastName.length() == 0) {
            System.out.println("The last name must be filled in.");
            return 0;
        }
        if (lastName.length() == 1) {
            System.out.println('"' + lastName + '"' + " is not a valid last name. It is too short.");
            return 0;
        }
        for (int i = 0; i < lastName.length(); i++) {
            char theOne = lastName.charAt(i);
            if (!Character.isAlphabetic(theOne)) {
                System.out.println("The last name should not have numbers.");
                return 0;
            }
        }
        return 1;
    }

    public static int validateZip(String theZip)
    {
        for (int i = 0; i < theZip.length(); i++) {
            char theOne = theZip.charAt(i);
            if (!Character.isDigit(theOne)) {
                System.out.println("The ZIP code must be numeric.");
                return 0;
            }
        }
        return 1;
    }
    public static int validateID(String theId)
    {
        for (int i = 0; i < 2; i++) {
            char theOne = theId.charAt(i);
            if (Character.isAlphabetic(theOne)) {
                if(Character.isUpperCase(theOne))
                {
                    continue;
                }
                else
                {
                    System.out.println(theId + " is not a valid ID.");
                    return 0;
                }
            }
            else
            {
                System.out.println(theId + " is not a valid ID.");
                return 0;
            }
        }
        char spotThree = theId.charAt(2);
        if(spotThree != '-')
        {
            System.out.println(theId + " is not a valid ID.");
            return 0;
        }
        for (int i = 3; i < 7; i++) {
            char theOne = theId.charAt(i);
            if (Character.isDigit(theOne)) {
                continue;
            }
            else
            {
                System.out.println(theId + " is not a valid ID.");
                return 0;
            }
        }
        return 1;
    }
}
