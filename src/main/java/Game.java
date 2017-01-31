
public class Game {

    public static Jar jar;
    public static int incorrectGuesses;
    public static Prompter prompter;


    public static void main(String[] args) {

        prompter = new Prompter();

        String itemName = prompter.promptForItem();

        int maxNumberOfItems = prompter.promptForMaxNumberOfItems(itemName);

        jar = new Jar(itemName, maxNumberOfItems);

        int guess = prompter.promptForGuess(jar);

        prompter.won(guess, jar);
    }
}
