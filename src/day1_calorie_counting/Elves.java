package day1_calorie_counting;

public class Elves {

    private int elfOrder;
    private int caloriesCollected;

    public Elves(int elfOrder, int caloriesCollected) {
        this.elfOrder = elfOrder;
        this.caloriesCollected = caloriesCollected;
    }


    @Override
    public String toString() {
        return "\nElf "+ elfOrder + " has collected " + caloriesCollected + " calories";
    }

    public int getElfOrder() {
        return elfOrder;
    }

    public void setElfOrder(int elfOrder) {
        this.elfOrder = elfOrder;
    }

    public int getCaloriesCollected() {
        return caloriesCollected;
    }

    public void setCaloriesCollected(int caloriesCollected) {
        this.caloriesCollected = caloriesCollected;
    }
}
