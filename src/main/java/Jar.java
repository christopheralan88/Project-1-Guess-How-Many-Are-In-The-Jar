
import java.util.Random;


public class Jar {

    private String itemName;
    public static int MAX_NUMBER_OF_ITEMS;
    private int numberOfItems;


    public Jar(String itemName, int numberOfItems){
        this.itemName = itemName;
        this.MAX_NUMBER_OF_ITEMS = numberOfItems;
        this.numberOfItems = fill();
    }

    public String getItemName() {
        return itemName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    private int fill() {
        Random random = new Random();
        int number;

        // Loop until number variable is not 0.  We don't want 0 items in the jar.
        do {
            number = random.nextInt(MAX_NUMBER_OF_ITEMS + 1); // +1 because random generates number < parameter.
        } while (number == 0);
        return number;
    }


    /*public enum JarItems{
        GUMBALLS,
        JELLY_BEANS,
        CHICKEN_WINGS;
    }*/



}
