package day3_rucksack_reorginazation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filepath = "puzzle_inputs/day3_input.csv";
        List<Rucksack> myList = importCSV(filepath);

        System.out.println(myList.get(0));

        overlappingContent(myList);


    }

    public static void overlappingContent(List<Rucksack> list) {
        int sum = 0;

        for (Rucksack r : list) {
            r.separateCompartments();

            String partOne = r.getFirstHalf();
            String partTwo = r.getSecondHalf();

            boolean foundMatch = false;

            for (int i = 0; i < partOne.length(); i++) {                // loop through the first half
                if (foundMatch) {
                    break;
                }
                char c = partOne.charAt(i);
                // store the character
                for (int j = 0; j < partTwo.length(); j++) {            // loop through the second half to find a match
                    char d = partTwo.charAt(j);
                    if (c - d == 0) {                                   // found a match
                        String match = String.valueOf(c);
                        System.out.println("Overlapping character between " + partOne + " and " + partTwo + " : " + match);
                        sum += convertCharValue(c);
                        foundMatch = true;
                        break;
                    }
                }
            }
        }

        System.out.println("The total sum of priorities is: " + sum);

    }

    private static List<Rucksack> importCSV(String filepath) {
        List<Rucksack> backpacks = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(filepath));
            csvReader.useDelimiter(",");

            while (csvReader.hasNext()) {
                String s = csvReader.nextLine();
                backpacks.add(new Rucksack(s));
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.printf("Error: file '%s' was not found.", filepath);
        }
        return backpacks;
    }

    public static int convertCharValue (char charValue) {
        int value = 0;
        if (charValue >= 97) {
            value = charValue - 96;
        } else if (charValue <= 90) {
            value = charValue - 38;
        }
        return value;
    }

}
