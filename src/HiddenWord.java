import java.util.Scanner;

public class HiddenWord {
    // Objects
    public String hiddenWord;
    public String guess;

    // Constructor
    public HiddenWord(String hw) {
        hiddenWord = hw.toUpperCase();
    }

    // Methods
    public String getHiddenWord() {
        return hiddenWord;
    }


    public String getHint(String guess) {
        // Check for uppercase
        if (guess == null || !guess.equals(guess.toUpperCase())) {
            throw new IllegalArgumentException("Your guess (" + guess + ") does not contain all uppercase letters. Your guess must contain all uppercase letters!");
        }

        // Check for length
        if (guess.length() != hiddenWord.length()) {
            throw new IllegalArgumentException("Your guess (" + guess + ") has " + guess.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!");
        }


        String hint = "";

        // Loop through each char of the String and check if it is correct.
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (guess.charAt(i) == hiddenWord.charAt(i)) {
                hint += guess.charAt(i);
            }
            else if (hiddenWord.contains("" + guess.charAt(i))) {
                hint += "+";
            }
            else {
                hint += "*";
            }
        }

        return hint;
    }
}
