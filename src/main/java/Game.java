
public class Game {

    public static int incorrectGuesses;
    public static Prompter prompter;


    public static void main(String[] args) {
        prompter = new Prompter();
        prompter.play();
    }
}
