import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Day3 {
    
    public Day3() {

    }

    public int getValue(char c) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return str.indexOf(c) + 1;
    }

    public void readFile() {
        String[] strArr = new String[2];
        int total = 0;
        try (Scanner scan = new Scanner(new File("input.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                int middle = line.length() / 2;
                strArr[0] = line.substring(0, middle);
                strArr[1] = line.substring(middle);
                total += getValue(getMatches(strArr[0], strArr[1]));
            }
                System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void readBadges() {
        String[] strArr = new String[3];
        int total = 0;
        int counter = 0;
        try (Scanner scan = new Scanner(new File("input.txt"))) {
            while (scan.hasNextLine()) {
                if (counter == 3) {
                    total += getValue(getBadgeMatches(strArr[0], strArr[1], strArr[2]));
                    counter = 0;
                }
                String line = scan.nextLine(); 
                strArr[counter] = line;
                counter++;
            }
                System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public char getMatches(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
          
            // Check if the character exists in str2
            if (str2.indexOf(c) >= 0) {
              // The character exists in str2
              return c;
            }
          }
        return ' ';
    }

    public char getBadgeMatches(String str1, String str2, String str3) {
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
          
            // Check if the character exists in str2 and str 3
            if (str2.indexOf(c) >= 0 && str3.indexOf(c) >= 0) {
              // The character exists in str2
              return c;
            }
          }
        return ' ';
    }



    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.readFile();
        day3.readBadges();
    }
}
