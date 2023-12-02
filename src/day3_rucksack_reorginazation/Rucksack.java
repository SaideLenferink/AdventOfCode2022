package day3_rucksack_reorginazation;

public class Rucksack {

    private String content;
    private String firstHalf;
    private String secondHalf;
    private int length;

    public Rucksack(String content) {
        this.content = content;
    }

    public void separateCompartments() {
        length = content.length();
        firstHalf = content.substring(0, (int) (0.5 * length));
        secondHalf = content.substring((int) (0.5 * length), length);
    }

    public String getFirstHalf() {
        return firstHalf;
    }

    public String getSecondHalf() {
        return secondHalf;
    }

    @Override
    public String toString() {
        return "\n" + content;
    }
}
