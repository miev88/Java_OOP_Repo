import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class HangMan {
    private String originalTitle;
    private String displayedTitle;
    private List<Character> usedCharsList;

    /**
     * Read text file.
     * Create a Scanner and an ArrayList.
     * Store each line in the text into one list entry.
     * Select random movie from the list.
     * Throws FileNotFoundException if file is not found.
     * FileNotFoundException is handled in the main().
     */
    HangMan() throws FileNotFoundException {
        File file = new File("moviesList.txt");
        Scanner fileScanner = new Scanner(file);
        List<String> movieList = new ArrayList<>();
        usedCharsList = new ArrayList<>();
        textToList(fileScanner, movieList);
        originalTitle = selectRandomMovie(movieList);
        displayedTitle = lettersToUnderscore(originalTitle);
    }

    /**
     * Read each line of a text file using a Scanner and saves it into a list cell.
     *
     * @param fileScanner A Scanner object
     * @param list        An ArrayList
     */
    private void textToList(Scanner fileScanner, List<String> list) {
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            list.add(line);
        }
    }

    /**
     * Selects a random title from a list where movie titles are stored.
     *
     * @param movieList An ArrayList
     * @return The movie title
     */
    private String selectRandomMovie(List movieList) {
        int randomMovieIndex = (int) (Math.random() * movieList.size());
        return (String) movieList.get(randomMovieIndex);
    }

    /**
     * Converts letters and numbers to "_" but preserves the spaces.
     *
     * @param movieName The movie name
     * @return The same name, but with all letters/number converted to "_"
     */
    private String lettersToUnderscore(String movieName) {
        return movieName.replaceAll("[a-zA-Z_0-9]", "_");
        // Apostrophes are not hidden!
    }

    public String checkGuess(char guess) {
        saveUsedChar(guess);
        int index = originalTitle.indexOf(guess);
        char[] displayedTitleChars = displayedTitle.toCharArray();
        while (index != -1) {
            displayedTitleChars[index] = guess;
            index = originalTitle.indexOf(guess, index + 1);
        }
        displayedTitle = String.valueOf(displayedTitleChars);
        return displayedTitle;
    }

    /**
     * Return a String that represents what the (partially) hidden
     *   title of the movie during the game.
     * @return The title to display
     */
    public String getDisplayedTitle() {
        return displayedTitle;
    }

    /**
     * Save the char entered by the user.
     * @param character the letter/number entered by the user
     */
    private void saveUsedChar(char character) {
        usedCharsList.add(character);
    }

    /**
     * Return the characters used by the user so far.
     * @return The characters already used
     */
    public String displayUsedChars() {
        return usedCharsList.toString();
    }

    /**
     * Return the original title (no hidden letters)
     * @return the original title
     */
    public String getOriginalTitle() {
        return originalTitle;
    }
}
