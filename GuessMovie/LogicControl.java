import java.io.FileNotFoundException;
import java.util.Scanner;


public class LogicControl {

    public static void main(String[] args) {
        try {
            HangMan hangManGame = new HangMan();
            int lifePointsLeft = 10;
            Scanner keyboardScanner = new Scanner(System.in);

            System.out.println("WELCOME TO THE HANG MAN GAME!");

            while (lifePointsLeft > 0) {
                String displayedTitle = hangManGame.getDisplayedTitle();
                System.out.println("Movie title: " + displayedTitle);
                //displayedTitle.replaceAll(" ", "").length()
                String listUsedChars = hangManGame.displayUsedChars();
                System.out.println("Characters tried so far: " + listUsedChars);
                System.out.println("Enter a single letter. You have " +
                        lifePointsLeft + " trials left.");

                // select first character only from cmd
                char guess = keyboardScanner.nextLine().charAt(0);
                // handle white spaces
                while (Character.isWhitespace(guess)) {
                    System.out.println("White space is not a valid character!");
                    guess = keyboardScanner.nextLine().charAt(0);
                }
                // handle already used characters
                while (listUsedChars.indexOf(guess) != -1) {
                    System.out.println("You have already tried this character!");
                    guess = keyboardScanner.nextLine().charAt(0);
                }
                // check if character is present. Update string if it is
                String updatedDisplayedTitle = hangManGame.checkGuess(guess);
                // if not present, reduce number of trials left
                if (displayedTitle.equals(updatedDisplayedTitle)) {
                    lifePointsLeft--;
                }
                // check if win situation
                if (!updatedDisplayedTitle.contains("_")) {
                    System.out.println("The movie title is: " + updatedDisplayedTitle);
                    System.out.println("YOU ARE THE WINNER!");
                    break;
                }
            }
            // message for game over
            if (lifePointsLeft <= 0) {
                System.out.println("GAME OVER!");
                System.out.println("The movie title was: " +
                        hangManGame.getOriginalTitle());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. TIP: Case sensitivity matters");
        }
    }
}
