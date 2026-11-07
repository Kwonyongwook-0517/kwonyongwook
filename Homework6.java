
import java.util.Scanner;

public class Homework6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] history = new String[10];
        String[] list = new String[1000];

        int historyCount = 0;
        int listCount = 0;
        String last = "";

        while (true) {
            System.out.print("jshell> ");
            String input = sc.nextLine();

            if (input.equals("/exit")) {
                System.out.println("Goodbye.");
                break;
            }

            if (input.equals("/help")) {
                System.out.println("Type a Java language expression, statement, or declaration.");
                System.out.println("Or type one of the following commands:");
                System.out.println("/list: list the source you have typed.");
                System.out.println("/exit: exit the jshell tool");
                System.out.println("/history: history of what you have typed.");
                System.out.println("/!: rerun last snippet.");
            }
            else if (input.equals("/history")) {
                for (int i = 0; i < historyCount; i++) {
                    System.out.println(history[i]);
                }
            }
            else if (input.equals("/list")) {
                for (int i = 0; i < listCount; i++) {
                    System.out.println((i + 1) + " : " + list[i]);
                }
            }
            else if (input.equals("/!")) {
                if (!last.equals("")) {
                    System.out.println("Re-running '" + last + "'.");
                }
            }
            else if (input.startsWith("/")) {
                System.out.println("Invalid command: " + input);
                System.out.println("Type /help for help.");
            }
            else {
                System.out.println("Running '" + input + "'.");

                last = input;

                if (listCount < 1000) {
                    list[listCount] = input;
                    listCount++;
                }
            }

            if (!input.equals("/history") &&
                    !input.equals("/list") &&
                    !input.equals("/!")) {

                if (historyCount == 10) {
                    historyCount = 0;
                    System.out.println("The history buffer is cleared.");
                }

                history[historyCount] = input;
                historyCount++;
            }
        }

        sc.close();
    }
}
