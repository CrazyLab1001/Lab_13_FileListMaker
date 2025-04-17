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
        System.out.println("Make a list!");
        do {
            display(userList);
            userChoice = SafeInput.getRegEXString(in, "Pick an option: Add, Delete, Insert, Print, or Quit. [A/D/I/P/Q]", "[ADIPQ]");
            // regex choices are only in caps since the SafeInput converts them to uppercase (for simplicity)
            switch (userChoice) {
              case "A":
                addToList = SafeInput.getNonZeroLenString(in, "What would you like to add to the list?");
                userList.add(addToList);
                  System.out.println(addToList + " was added to the list!");
                break;
                case "D":
                    spotOnList = SafeInput.getRangedInt(in, "Which spot on the list would you like to delete?", 1, (userList.size() + 1));
                    spotOnList--;
                    confirmChoice = SafeInput.getYNConfirm(in, "Delete " + userList.get(spotOnList) + "?");
                    if (confirmChoice == true)
                    { userList.remove(spotOnList);
                        System.out.println("Officially deleted!");
                        break;}
                    else {
                        System.out.println("Nevermind then!");
                    }
                    break;
                case "I":
                    spotOnList = SafeInput.getRangedInt(in, "Where would you like to insert something new?", 1, (userList.size() + 1));
                    spotOnList--;
                    addToList = SafeInput.getNonZeroLenString(in, "What would you like to insert to the list?");
                    userList.add(spotOnList,addToList);
                    System.out.println("Inserted!");
                    break;
                case "P":
                    display(userList);
                    System.out.println("");
                    break;
                default:
                    confirmChoice = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    if (confirmChoice == true) {
                        System.out.println("Bye bye! Ending program!");
                        done = true;
                    } else {
                        System.out.println("Nevermind then! :)");
                    }
                    break; }
        } while (!done);
    }
    private static void display(ArrayList<String> list) {
        for (int cnt = 0; cnt < list.size(); cnt++) {
            System.out.println((cnt + 1) + ". " + list.get(cnt));
        }

    }
}