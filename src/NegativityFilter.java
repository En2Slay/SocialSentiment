import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NegativityFilter {
    private static ArrayList<String> negativeWords = makeList();

    public static void filter(String input) {
        input.toLowerCase();
        // ArrayList<String> punctuation = new ArrayList<String>();
        String[] punctuation = {".", "!", "?", ",", "#", "(", ")", ";"};
        // if (input.contains(".") || input.contains("!") || input.contains("?") ||
        //     input.contains(",") || input.contains("#") || input.contains("(") ||
        //     input.contains(")") || input.contains(";")) {
        //         input.indexOf(str)
        //     }

        for (String punc : punctuation) {
            if (input.contains(punc)) {
                input = input.substring(0, input.indexOf(punc)) + input.substring(input.indexOf(punc) + 1);
            }
        }
        // input.replaceAll(".", "");
        // input.replaceAll("!", "");
        // input.replaceAll("?", "");
        // input.replaceAll(",", "");
        // input.replaceAll("#", "");
        // input.replaceAll("(", "");
        // input.replaceAll(")", "");
        // input.replaceAll(";", "");

        String[] temp = input.split(" ");
        ArrayList<String> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(temp));

        tempList.retainAll(negativeWords);
        System.out.print("Inappropriate statement. Contains: ");
        for (String s : tempList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /* Auxiliary methods */

    private static ArrayList<String> makeList() {
        ArrayList<String> tempList = new ArrayList<>();

        try {
            File myObj = new File("NegativeWordList.txt");
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.toLowerCase().split(" ");
                tempList.addAll(Arrays.asList(temp));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return tempList;
    }
}



// import java.util.ArrayList;
// import java.util.Arrays;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;

// public class NegativityFilter {
//     private static ArrayList<String> negativeWords = makeList();

//     public static void filter(String input) {
//         input.toLowerCase();
//         String[] temp = input.split(" ");
//         ArrayList<String> tempList = new ArrayList<>();
//         tempList.addAll(Arrays.asList(temp));

//         tempList.retainAll(negativeWords);
//         System.out.print("Inappropriate statement. Contains: ");
//         for (String s : tempList) {
//             System.out.print(s + " ");
//         }
//         System.out.println();
//     }

//     /* Auxiliary methods */

//     private static ArrayList<String> makeList() {
//         ArrayList<String> tempList = new ArrayList<>();

//         try {
//             File myObj = new File("NegativeWordList.txt");
//             Scanner scanner = new Scanner(myObj);
//             while (scanner.hasNextLine()) {
//                 String data = scanner.nextLine();
//                 String[] temp = data.toLowerCase().split(" ");
//                 tempList.addAll(Arrays.asList(temp));
//             }
//             scanner.close();
//         } catch (FileNotFoundException e) {
//             System.out.println("File not found");
//             e.printStackTrace();
//         }

//         return tempList;
//     }
// }
