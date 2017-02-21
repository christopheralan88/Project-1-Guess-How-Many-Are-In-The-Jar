import java.util.Scanner;


public class Prompter {

    private Scanner scanner;
    public static Jar jar;


    public Prompter() {
        scanner = new Scanner(System.in);
    }

    public void play() {
        String itemName = promptForItem();
        int maxNumberOfItems = promptForMaxNumberOfItems(itemName);
        jar = new Jar(itemName, maxNumberOfItems);
        int guess = promptForGuess(jar);
        won(guess, jar);
    }

    public String promptForItem() {
        System.out.println("What type of item?");
        return scanner.next();
    }

    public int promptForMaxNumberOfItems(String itemName) {
        System.out.printf("What is the maximum amount of %s? %n", itemName);
        int number = scanner.nextInt();
        while (number == 0){
            System.out.println("The number must be greater than 0.");
            number = scanner.nextInt();
        }
        return number;
    }

    // returns the number of items the user guesses are in the jar.
    public int promptForGuess(Jar jar) {
        System.out.printf("How many %s are in the jar? Pick a number between 1 and %d. %n", jar.getItemName(),
                jar.MAX_NUMBER_OF_ITEMS);

        int guess = scanner.nextInt();

        while (guess > jar.MAX_NUMBER_OF_ITEMS) {
            System.out.printf("Your guess must be less than %d. %n", jar.MAX_NUMBER_OF_ITEMS);
            guess = scanner.nextInt();
        }

        /*if (guess > jar.MAX_NUMBER_OF_ITEMS) {
            System.out.printf("Your guess must be less than %d. %n", jar.MAX_NUMBER_OF_ITEMS);
            promptForGuess(jar); // recursive call - start method all over again.
        }*/

        return guess;
    }

    public void won(int guess, Jar jar) {
        while (guess != jar.getNumberOfItems()) {
            guessIsTooHighOrTooLow(guess, jar);
            Game.incorrectGuesses++; // Increment incorrectGuesses by 1 if the guess is incorrect.
            System.out.println("Sorry that's not the right number of items in the jar.  Try again.");
            guess = scanner.nextInt();
        }
        Game.incorrectGuesses++; // Increment incorrectGuesses by 1 if the guess is correct.
        System.out.printf("You got it in %d attempt(s) %n", Game.incorrectGuesses);
        System.exit(0);
    }

    /* tests whether user's guess is higher or lower than jar's numberOfItems field.  There is no logic to test if the
       guess equals the jar's numberOfItems field, because that is tested in the won() method before this method is called.
       Maybe it would be a good idea to hold that logic in this function, too?
    */
    private void guessIsTooHighOrTooLow(int guess, Jar jar) {
        if (guess > jar.getNumberOfItems()) {
            System.out.println("Your guess is too high");
        } else {
            System.out.println("Your guess is too low");
        }
    }

}
