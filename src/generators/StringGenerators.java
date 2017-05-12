package generators;

import java.util.Random;

/**
 * Created by mikearias on 5/9/17.
 */
public class StringGenerators {
    private static String currentString;
    private static String vocals = "aeiou";
    private static String consonants = "bcdfghjklmnpqrstvwxyz";
    private static String characters = "abcdefghijklmnopqrstuvwxyz";
    private static String specialCharacters = "!@#$%^&*()";
    private static String mixedCharacters = characters + specialCharacters;
    private static String numbers = "0123456789";
    private static String alphaNum = characters + numbers;
    private static Random rng = new Random();

    public static String getName(boolean legible, int count) {
        currentString = null;
        char[] text = new char[count];
        for (int i = 0; i < count; i++)
        {
            if (legible) {
                if ((i+1)%2 == 0) {
                    text[i] = consonants.charAt(rng.nextInt(consonants.length()));
                } else {
                    text[i] = vocals.charAt(rng.nextInt(vocals.length()));
                }
            } else {
                text[i] = characters.charAt(rng.nextInt(characters.length()));
            }
        }

        text[0] = Character.toUpperCase(text[0]);
        currentString = new String(text);
        return currentString;
    }

    public static String getEmail(boolean legible, Integer count) {
        currentString = null;
        char[] text = new char[count];
        for (int i = 0; i < count; i++)
        {
            if (legible) {
                if ((i+1)%2 == 0) {
                    text[i] = consonants.charAt(rng.nextInt(consonants.length()));
                } else {
                    text[i] = vocals.charAt(rng.nextInt(vocals.length()));
                }
            } else {
                text[i] = characters.charAt(rng.nextInt(characters.length()));
            }
        }

        currentString = new String(text);

        return currentString + "@slipry.net";
    }

    public static String getPassword(boolean legible, Integer count) {
        currentString = null;
        char[] text = new char[count];
        for (int i = 0; i < count; i++)
        {
            if (legible) {
                if ((i+1)%2 == 0) {
                    text[i] = consonants.charAt(rng.nextInt(consonants.length()));
                } else if ((i+1)%3 == 0) {
                    text[i] = specialCharacters.charAt(rng.nextInt(specialCharacters.length()));
                } else {
                    text[i] = vocals.charAt(rng.nextInt(vocals.length()));
                }
            } else {
                text[i] = mixedCharacters.charAt(rng.nextInt(mixedCharacters.length()));
            }
        }

        currentString = new String(text);

        return currentString;
    }

    public static String getNumbers(boolean legible, Integer count) {
        currentString = null;
        char[] text = new char[count];
        for (int i = 0; i < count; i++)
        {
            text[i] = numbers.charAt(rng.nextInt(numbers.length()));
        }

        currentString = new String(text);

        return currentString;
    }

    public static String getAlphaNum(boolean legible, Integer count) {
        currentString = null;
        char[] text = new char[count];
        for (int i = 0; i < count; i++)
        {
            if (legible) {
                if ((i+1)%2 == 0) {
                    text[i] = numbers.charAt(rng.nextInt(numbers.length()));
                } else {
                    text[i] = characters.charAt(rng.nextInt(characters.length()));
                }
            } else {
                text[i] = alphaNum.charAt(rng.nextInt(alphaNum.length()));
            }
        }

        currentString = new String(text);

        return currentString;
    }
}
