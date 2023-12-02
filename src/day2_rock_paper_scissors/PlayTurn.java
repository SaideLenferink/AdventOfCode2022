package day2_rock_paper_scissors;

import static day2_rock_paper_scissors.RockPaperScissors.*;

public class PlayTurn {

    private final Enum<RockPaperScissors> opponent;
    private final Enum<RockPaperScissors> player;
    private String outcome;
    private int playerScore;


    public PlayTurn(Enum<RockPaperScissors> opponent, Enum<RockPaperScissors> player) {
        this.opponent = opponent;
        this.player = player;
        outcome = calculateOutcome();
        playerScore = calculatePlayerScore(outcome);
    }

    public PlayTurn(Enum<RockPaperScissors> opponent, String outcome) {
        this.opponent = opponent;
        player = getPlayerMove(opponent, outcome);
        this.outcome = outcome;
        playerScore = calculatePlayerScore(outcome);
    }

    private int calculatePlayerScore(String outcome) {
        switch (outcome) {
            case "lose" -> playerScore += 0;
            case "draw" -> playerScore += 3;
            case "win" -> playerScore += 6;
            default -> System.out.println("input error");
        }
        String playerChoice = String.valueOf(player);
        switch (playerChoice) {
            case "ROCK" -> playerScore += 1;
            case "PAPER" -> playerScore += 2;
            case "SCISSORS" -> playerScore += 3;
            default -> System.out.println("input error");
        }
        return playerScore;
    }

    private Enum<RockPaperScissors> getPlayerMove(Enum<RockPaperScissors> opponent, String outcome) {
        RockPaperScissors opponentMove = (RockPaperScissors) opponent;
        Enum<RockPaperScissors> player = null;
        switch (outcome) {
            case "draw" -> {
                switch (opponentMove) {
                    case ROCK -> player = ROCK;
                    case PAPER -> player = PAPER;
                    case SCISSORS -> player = SCISSORS;
                }
            }
            case "lose" -> {
                switch (opponentMove) {
                    case ROCK -> player = SCISSORS;
                    case PAPER -> player = ROCK;
                    case SCISSORS -> player = PAPER;
                }
            }
            case "win" -> {
                switch (opponentMove) {
                    case ROCK -> player = PAPER;
                    case PAPER -> player = SCISSORS;
                    case SCISSORS -> player = ROCK;
                }
            }
        }
        return player;
    }

    private String calculateOutcome() {

        if (opponent.equals(ROCK)) {
            if (player.equals(ROCK)) {
                outcome = "draw";
            } else if (player.equals(PAPER)) {
                outcome = "win";
            } else if (player.equals(SCISSORS)) {
                outcome = "lose";
            }
        } else if (opponent.equals(PAPER)) {
            if (player.equals(ROCK)) {
                outcome = "lose";
            } else if (player.equals(PAPER)) {
                outcome = "draw";
            } else if (player.equals(SCISSORS)) {
                outcome = "win";
            }
        } else if (opponent.equals(SCISSORS)) {
            if (player.equals(ROCK)) {
                outcome = "win";
            } else if (player.equals(PAPER)) {
                outcome = "lose";
            } else if (player.equals(SCISSORS)) {
                outcome = "draw";
            }
        }
        return outcome;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    @Override
    public String toString() {
        return "\nOpponent played %s and Player played %s, resulting the player to %s with a score of %d".formatted(opponent, player, outcome, playerScore);
    }
}


