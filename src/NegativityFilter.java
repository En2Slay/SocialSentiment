// Credit for negative word list:
// Bing Liu, Minqing Hu and Junsheng Cheng. "Opinion Observer: Analyzing 
//     and Comparing Opinions on the Web." Proceedings of the 14th 
//     International World Wide Web conference (WWW-2005), May 10-14, 
//     2005, Chiba, Japan.

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NegativityFilter {
    private static ArrayList<String> negativeWords = makeList();

    public static void filter(String input) {
        input.toLowerCase();
        String[] punctuation = {".", "!", "?", ",", "#", "(", ")", ";"};

        // Take out punctuation
        for (String punc : punctuation) {
            int puncIndex = input.indexOf(punc);
            if (puncIndex != -1) {
                input = input.substring(0, puncIndex) + input.substring(puncIndex + 1);
            }
        }

        String[] temp = input.split(" ");
        ArrayList<String> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(temp));

        // Keep only recognized negative words in tempList
        tempList.retainAll(negativeWords);
        if (tempList.size() > 0) {
            System.out.print("This statement contains the following negatively-charged words: ");
            for (int i = 0; i < tempList.size(); i++) {
                if (i < tempList.size() - 1) {
                    System.out.print(tempList.get(i) + ", ");
                } else {
                    System.out.println(tempList.get(i));
                    System.out.println("Please consider how your language use can project underlying connotations onto social platforms in the future.");
                }
            }
        }
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
