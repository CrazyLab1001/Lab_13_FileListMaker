import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args) {

    }

//        * @param pipe a Scanner opened to read from System.in
//     * @param prompt prompt for the user
//     * @return a String response that is not zero length
//     */

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Please print a valid input, unlike: " + trash);
            }
        } while (!done);
        return result;
} public static double getDouble(Scanner pipe, String prompt) {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Please print a valid input, unlike: " + trash);
            }
        } while (!done);
         return result;}

   public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
            int result = 0;
            boolean done = false;
            String trash = "";
            do {
                System.out.print("\n" + prompt + ": ");
                if (pipe.hasNextInt())
                {
                    result = pipe.nextInt();
                    pipe.nextLine();
                    if (result >= low && result <= high) {
                        done = true;
                    } else {
                        System.out.println("Please put in the ranged input unlike the value: " + result );
                    }
                } else {
                    trash = pipe.nextLine();
                    System.out.println("Please insert a valid input unlike: " + trash ); }
            } while (!done);
            return result; }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                pipe.nextLine();
                if (result >= low && result <= high) {
                    done = true;
                } else {
                    System.out.println("Please put in the ranged input unlike the value: " + result );
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Please insert a valid input unlike: " + trash ); }
        } while (!done);
        return result; }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean result = false;
        String YNOption = "";
        boolean done = false;
        String trash = "";
        do {
            System.out.print("\n" + prompt + ": ");
            YNOption = pipe.nextLine();
            YNOption = YNOption.toUpperCase();
            switch (YNOption) {
                case "Y":
                    result = true;
                    done = true;
                    break;
                case "N":
                    result = false;
                    done = true;
                    break;
                default:
                    trash = YNOption;
                    System.out.println("Please insert a valid input unlike: " + trash );
            }
        } while (!done);
        return result;
    }
    public static String getRegEXString (Scanner pipe, String prompt, String regEXPattern) {
        String value = "";
        boolean done = false;
        do {
            System.out.println( "\n" + prompt + ": ");
            value = pipe.nextLine();
            value = value.toUpperCase();
            if (value.matches(regEXPattern)){
                done = true;
            } else {
                System.out.println("Invalid input! Please input a valid option, unlike: " + value);
            }
        } while (!done);
        return value; }
    public static String prettyPrettyHeader(String message){
        int messageLength = message.length();
        int spaceForCentering = (60 - messageLength - 6);
        spaceForCentering = spaceForCentering/2;
        for (int cnt = 1; cnt <= 60; cnt++) {
            System.out.print("*");
        }
        System.out.println();
        for (int cnt = 1; cnt <= 3; cnt++) {
            System.out.print("*");
        }
        for (int cnt = 1; cnt <= spaceForCentering; cnt++) {
            System.out.print(" ");
        }
        System.out.print(message);
        for (int cnt = 1; cnt <= spaceForCentering; cnt++) {
            System.out.print(" ");
        }
        for (int cnt = 1; cnt <= 3; cnt++) {
            System.out.print("*");
        }
        System.out.println();
        for (int cnt = 1; cnt <= 60; cnt++) {
            System.out.print("*");
        }
        return message;}
    }
