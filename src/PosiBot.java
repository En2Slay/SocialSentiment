import java.util.Scanner;

public class PosiBot {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        System.out.print("Hello, my name is Posibot. What is your name? ");

        // Name
        String name = null;
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        }
        
        System.out.println("Nice to meet you, " + name + "!");
        
        // Explanation of what the bot does
        System.out.print("Would you like to know more about what I do? Type 'y' for yes or 'n' for no: ");
        String input = null;
        boolean readyForInput = false;
        while (!readyForInput) {
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                if (input.toLowerCase().equals("y")) {
                    System.out.println("My job is to detect negative comments and filter them out to make online communities more positive and friendly!");
                    System.out.println("Please enter a comment: ");
                    readyForInput = true;
                    break;
                } else if (input.toLowerCase().equals("n")) {
                    System.out.print("Okay, would you like to continue? Type 'y' for yes or type 'n' for no: ");
                    while (true) {
                        if (scanner.hasNextLine()) {
                            input = scanner.nextLine();
                            if (input.toLowerCase().equals("y")) {
                                System.out.println("Please enter a comment: ");
                                readyForInput = true;
                            } else if (!input.toLowerCase().equals("n")) {
                                System.out.print("Please type 'y' for yes or 'n' for no: ");
                            }
                        }
                        if (readyForInput || input.equals("n")) {
                            break;
                        }
                    }
                } else {
                    System.out.print("Please type 'y' for yes or 'n' for no: ");
                }

                if (input.equals("n")) {
                    break;
                }
            }
        }
        
        // Accept and filter comment
        if (readyForInput && scanner.hasNextLine()) {
            input = scanner.nextLine();
            NegativityFilter.filter(input);
        }

        scanner.close();

        // Thank you message
        System.out.println();
        System.out.println("I really enjoyed this conversation! Thank you very much, and be sure to spread positvity on the internet!");
    }
}