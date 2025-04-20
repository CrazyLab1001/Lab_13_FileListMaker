import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean done = false;
        String userChoice = "";
        boolean confirmChoice;
        String addToList = "";
        int spotOnList = 0;
        ArrayList<String> userList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean needsToBeSaved = false;
        System.out.println("Please select a .txt file!");
        userList = openFile(userList);
        do {
            display(userList);
            userChoice = SafeInput.getRegEXString(in, "Pick an option: Add, Delete, Insert, View, Move, Open, Copy, Save, or Quit. [A/D/I/V/M/O/C/S/Q]", "[ADIVQ]");
            // regex choices are only in caps since the SafeInput converts them to uppercase (for simplicity)
            switch (userChoice) {
                case "A": // Add
                    addToList = SafeInput.getNonZeroLenString(in, "What would you like to add to the list?");
                    userList.add(addToList);
                    System.out.println(addToList + " was added to the list!");
                    needsToBeSaved = true;
                    break;
                case "D": // Delete
                    spotOnList = SafeInput.getRangedInt(in, "Which spot on the list would you like to delete?", 1, (userList.size() + 1));
                    spotOnList--;
                    confirmChoice = SafeInput.getYNConfirm(in, "Delete " + userList.get(spotOnList) + "?");
                    if (confirmChoice == true) {
                        userList.remove(spotOnList);
                        System.out.println("Officially deleted!");
                        needsToBeSaved = true;
                        break;
                    } else {
                        System.out.println("Nevermind then!");
                    }
                    break;
                case "I": // Insert
                    spotOnList = SafeInput.getRangedInt(in, "Where would you like to insert something new?", 1, (userList.size() + 1));
                    spotOnList--;
                    addToList = SafeInput.getNonZeroLenString(in, "What would you like to insert to the list?");
                    userList.add(spotOnList, addToList);
                    System.out.println("Inserted!");
                    needsToBeSaved = true;
                    break;
                case "V": // VIEW
                    display(userList);
                    System.out.println("");
                    break;
                case "M": // Move
                    spotOnList = SafeInput.getRangedInt(in, "Which line would you like to move?", 1, (userList.size() + 1));
                    spotOnList--;
                    needsToBeSaved = true;
                    break;
                case "O": // Open file
                    break;
                case "C": // Clear file
                    confirmChoice = SafeInput.getYNConfirm(in, "Wait! Are you sure you want to clear the list? You'll erase it all with no ")
                    break;
                case "S": // Save
                {
                    // code writer here
                }
                default:
                    confirmChoice = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    if (confirmChoice == true) {
                        if (needsToBeSaved == true) {
                            System.out.println("Wait! Would you like to save first?");
                        }
                    } else {
                        System.out.println("Nevermind then! :)");
                    }
                    break;
            }
        } while (!done);
    }

    private static void display(ArrayList<String> list) {
        for (int cnt = 0; cnt < list.size(); cnt++) {
            System.out.println((cnt + 1) + ". " + list.get(cnt));
        }

    }

    private static void saveFile() {
        System.out.println("Wait! Do you want to save this file first?");

    }

    private static ArrayList<String> openFile(ArrayList<String> list) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        File selectedFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src"); // opens in project src folder
        chooser.setCurrentDirectory(target.toFile());
        try {
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) // File choosen
            {
                selectedFile = chooser.getSelectedFile();
                target = chooser.getSelectedFile().toPath();  // File object, not a String filename
                inFile = new Scanner(target); // uses the scanner to analyze each line!
                do {
                    line = inFile.nextLine();
                    list.add(line);
                } while (inFile.hasNextLine());
                inFile.close();
            } else   // File chooser closed
            {
                System.out.println("You have to select a file! Ending program.");
                System.exit(0);
            }
        } catch (FileNotFoundException e) // Errors other than unpicked file
        {
            System.out.println("File Not Found Error!");
            e.printStackTrace();
        } catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error!");
            e.printStackTrace();
        }
        return list;
    }
}