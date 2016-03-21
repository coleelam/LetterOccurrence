import java.util.Arrays;
import java.util.Scanner;

public class LetterOccurrence {

    static int asciiConvert = 97;
    static int alphabetLength = 26;

    public static String asterisks(int counts) {

        String stars = "";
        for (int i = 0; i < counts; i++) {              //add stars according to amount of occurrences
            stars += "*";
        }
        return stars;

    }

    public static int[] alphaOccurrence(String inputString) {

        int[] letterCount = new int[alphabetLength];
        char letter;
        int asciiVal;
        int alphabet;
        for (int i = 0; i < inputString.length(); i++) {        //create array of 26 0s, increment for each occurrence
            letter = inputString.charAt(i);
            asciiVal = (int)letter;
            alphabet = asciiVal - asciiConvert;
            if ((alphabet >= 0) && (alphabet <= (alphabetLength - 1))) {
                letterCount[alphabet]++;
            }
        }
        return letterCount;

    }

    public static void maxAlphas(int[] letterCount) {

        for (int i = 0; i < 5; i++) {                           //looking for max 5 letters
            int max = letterCount[0];
            int maxpos = 0;
            for (int j = 0; j < letterCount.length; j++) {      //find the max occurring letter
                if (letterCount[j] >= max) {
                    max = letterCount[j];
                    maxpos = j;
                }

            }
            System.out.printf("%10c\t (%d occurrences)\n", (char)(maxpos + asciiConvert), max);
            letterCount[maxpos] = 0;            //remove the highest max occurring in prep for next iteration
        }
        System.out.println();

    }

    public static void createTable(int[] letterCount) {

        for(int i = 0; i < letterCount.length; i++) {   //create a table displaying each char and their occurrences
            char letter = (char)(i + asciiConvert);
            System.out.print(letter);
            System.out.println("\t" + asterisks(letterCount[i]));
        }

    }

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        String inputString;
        String userResponse;

        System.out.println("Hello! This program is able to read your text, " +
                "count which letters occur the most, and then " +
                "print the five most frequent letters that appear.");

        do {

            System.out.println("\nPlease enter a sentence: ");
            inputString = sc.nextLine().toLowerCase().trim();                   //trim and convertCase of input

            int[] letterCount = alphaOccurrence(inputString);                   //invoke alphaOccurrence
            int[] letterCopy = Arrays.copyOf(letterCount, letterCount.length);  //create a copy for modification

            System.out.println("\nThe five most occurring letters were: ");
            maxAlphas(letterCopy);                                              //print max characters
            createTable(letterCount);                                           //create the table

            System.out.println("\nWould you like to try a different string?");  //prompt user to try again
            userResponse = sc.nextLine();

        } while(!userResponse.equalsIgnoreCase("no"));                          //continue as long as user wants

        System.out.println("\nGoodbye!");                                       //else say goodbye
        System.exit(0);                                                         //exit with 0 error code
    }

}
