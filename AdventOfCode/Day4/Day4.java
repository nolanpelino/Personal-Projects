import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day4 {

    public int total;
    public int total2;

    public Day4() {
    }

    public void readFile(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (compare(parseLine(line))) {
                total++;
            }
            if (compare2(parseLine(line))) {
                total2++;
            }
        }
    }   

    public int[] parseLine(String line)  {
        ArrayList<String> bounds = new ArrayList<String>();
        String ranges[] = line.split(",");  // Split by elves
        bounds.addAll(Arrays.asList(ranges[0].split("-")));  // Split by First elf's bounds
        bounds.addAll(Arrays.asList(ranges[1].split("-")));  // Split by Second elf's bounds
        int nums[] = new int[bounds.size()];
        for (int i = 0; i < bounds.size(); i++) {
            nums[i] = Integer.parseInt(bounds.get(i));  // Convers bounds to int array
        }
        return nums;
    }

    public boolean compare(int[] nums) {
        if (nums[0] <= nums[2] && nums[1] >= nums[3]) {  // elf 1 contains  all of elf 2
            return true;
        } else if (nums[0] >= nums[2] && nums[1] <= nums[3]) {  // elf 2 contains all of elf 1
            return true;
        } else {
            return false;
        }
    }

    public boolean compare2(int[] nums) {
        if (nums[1] >= nums[2] && nums[0] <= nums[2]) {  // elf 1 overlap
            return true;
        } else if (nums[3] >= nums[0] && nums[0] >= nums[2]) {  // elf 2 overlap
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day4 day4 = new Day4();
        day4.readFile("/home/nolanpelino/Personal-Projects/AdventOfCode/Day4/input.txt");
        System.out.println(day4.total);  // Prints total number of completely overlapping elves.
        System.out.println(day4.total2);  // Prints total number of partially overlapping elves.
    }
}
