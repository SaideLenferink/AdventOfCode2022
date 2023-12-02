package day1_calorie_counting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "puzzle_inputs/day1_input.csv";

        List<String> myBufferArray = new ArrayList<>();

        List<Elves> returnedElves = new ArrayList<>();
        int elfOrder = 1;
        int caloriesCollected = 0;

        try {
            Scanner cvsReader = new Scanner(new File(filePath));
            cvsReader.useDelimiter(",");

            while (cvsReader.hasNext()) {
                String s = cvsReader.nextLine();
                myBufferArray.add(s);
            }

            for (String s : myBufferArray) {
                if (!s.isBlank()) {
                    int c = Integer.parseInt(s);
                    caloriesCollected += c;
                } else {
                    returnedElves.add(new Elves(elfOrder, caloriesCollected));
                    elfOrder++;
                    caloriesCollected = 0;
                }
            }
            cvsReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.printf("Error: file '%s' was not found.", filePath);
        }

        returnedElves.sort(new Comparator<Elves>() {    // reverse sort the elves based on the amount of calories collected
            @Override
            public int compare(Elves o1, Elves o2) {
                return o2.getCaloriesCollected() - o1.getCaloriesCollected();
            }
        });

        // System.out.println(returnedElves);           // to confirm the sort
        System.out.println(returnedElves.get(0));       // the highest scoring elf
        int top3 = returnedElves.get(0).getCaloriesCollected()  // the top 3 scoring elves together
                + returnedElves.get(1).getCaloriesCollected()
                + returnedElves.get(2).getCaloriesCollected();

        System.out.printf("The top 3 elves collected %s calories together", top3);

    }
}


