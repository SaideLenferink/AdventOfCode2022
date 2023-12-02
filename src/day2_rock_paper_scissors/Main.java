package day2_rock_paper_scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<PlayTurn> allRounds = new ArrayList<>();

//        { // manual testcases to test the logic
//            PlayTurn turn1 = new PlayTurn(RockPaperScissors.SCISSORS, RockPaperScissors.PAPER);
//            PlayTurn turn2 = new PlayTurn(RockPaperScissors.SCISSORS, RockPaperScissors.ROCK);
//            PlayTurn turn3 = new PlayTurn(RockPaperScissors.ROCK, RockPaperScissors.PAPER);
//            PlayTurn turn4 = new PlayTurn(RockPaperScissors.PAPER, RockPaperScissors.PAPER);
//
//            allRounds.add(turn1);
//            allRounds.add(turn2);
//            allRounds.add(turn3);
//            allRounds.add(turn4);
//
//            System.out.println(allRounds);
//
//            System.out.println("-".repeat(20));
//
//            System.out.println("The final score of the Player against the Opponent is " + TotalScore(allRounds));
//        }

        String filePath = "puzzle_inputs/day2_input.csv";

        int firstStrategy = 1;
        int secondStrategy = 2;

        System.out.println("The total score of the Player vs the Opponent is " + totalScore(importedRounds(filePath, firstStrategy)));

        System.out.println("-".repeat(20));

        System.out.println("The total score of the Player vs the Opponent is " + totalScore(importedRounds(filePath, secondStrategy)));


    }

    private static int totalScore(List<PlayTurn> list) {
        int sum = 0;
        for (PlayTurn playTurn : list) {
            sum += playTurn.getPlayerScore();
        }
        return sum;
    }


    private static List<PlayTurn> importedRounds(String filePath, int strategy) {

        List<String> myBufferArray = new ArrayList<>();

        List<PlayTurn> allMoves = new ArrayList<>();

        try {
            Scanner csvReader = new Scanner(new File(filePath));
            csvReader.useDelimiter(",");

            while (csvReader.hasNext()) {
                String s = csvReader.nextLine();
                myBufferArray.add(s);
            }
            for (String s : myBufferArray) {
                String opponentMove = String.valueOf(s.charAt(0));
                switch (opponentMove) {
                    case "A" -> opponentMove = "ROCK";
                    case "B" -> opponentMove = "PAPER";
                    case "C" -> opponentMove = "SCISSORS";
                    default -> System.out.println("invalid character found");
                }
                RockPaperScissors opponentEnum = RockPaperScissors.valueOf(RockPaperScissors.class, opponentMove);

                if (strategy == 1) {
                    String playerMove = String.valueOf(s.charAt(2));
                    switch (playerMove) {
                        case "X" -> playerMove = "ROCK";
                        case "Y" -> playerMove = "PAPER";
                        case "Z" -> playerMove = "SCISSORS";
                        default -> System.out.println("invalid character found");
                    }
                    RockPaperScissors playerEnum = RockPaperScissors.valueOf(RockPaperScissors.class, playerMove);
                    allMoves.add(new PlayTurn(opponentEnum, playerEnum));
                }
                if (strategy == 2) {
                    String playerMove = String.valueOf(s.charAt(2));
                    switch (playerMove) {
                        case "X" -> playerMove = "lose";
                        case "Y" -> playerMove = "draw";
                        case "Z" -> playerMove = "win";
                        default -> System.out.println("invalid character found");
                    }
                    allMoves.add(new PlayTurn(opponentEnum, playerMove));
                }

            }

            csvReader.close();

        } catch (FileNotFoundException e) {
            System.out.printf("Error: file '%s' was not found.", filePath);
        }

        return allMoves;
    }

}
