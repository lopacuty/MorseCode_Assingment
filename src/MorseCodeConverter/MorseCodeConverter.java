package MorseCodeConverter;
import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeConverter {
    private static final HashMap<Character, String> englishToMorseMap = new HashMap<>();

    private static final HashMap<String, Character> morseToEnglishMap = new HashMap<>();

    static {
        englishToMorseMap.put('A', "*-");
        englishToMorseMap.put('B', "-***");
        englishToMorseMap.put('C', "-*-*");
        englishToMorseMap.put('D', "-**");
        englishToMorseMap.put('E', "*");
        englishToMorseMap.put('F', "**-*");
        englishToMorseMap.put('G', "--*");
        englishToMorseMap.put('H', "****");
        englishToMorseMap.put('I', "**");
        englishToMorseMap.put('J', "*---");
        englishToMorseMap.put('K', "-*-");
        englishToMorseMap.put('L', "*-**");
        englishToMorseMap.put('M', "--");
        englishToMorseMap.put('N', "-*");
        englishToMorseMap.put('O', "---");
        englishToMorseMap.put('P', "*--*");
        englishToMorseMap.put('Q', "--*-");
        englishToMorseMap.put('R', "*-*");
        englishToMorseMap.put('S', "***");
        englishToMorseMap.put('T', "-");
        englishToMorseMap.put('U', "**-");
        englishToMorseMap.put('V', "***-");
        englishToMorseMap.put('W', "*--");
        englishToMorseMap.put('X', "-**-");
        englishToMorseMap.put('Y', "-*--");
        englishToMorseMap.put('Z', "--**");

        morseToEnglishMap.put(".-", 'A');
        morseToEnglishMap.put("-...",'B');
        morseToEnglishMap.put("-.-.", 'C');
        morseToEnglishMap.put("-..", 'D');
        morseToEnglishMap.put(".", 'E');
        morseToEnglishMap.put("..-.", 'F');
        morseToEnglishMap.put("--.", 'G');
        morseToEnglishMap.put("....", 'H');
        morseToEnglishMap.put("..", 'I');
        morseToEnglishMap.put(".---", 'J');
        morseToEnglishMap.put("-.-", 'K');
        morseToEnglishMap.put(".-..", 'L');
        morseToEnglishMap.put("--", 'M');
        morseToEnglishMap.put("-.", 'N');
        morseToEnglishMap.put("---", 'O');
        morseToEnglishMap.put(".--.", 'P');
        morseToEnglishMap.put("--.-", 'Q');
        morseToEnglishMap.put(".-.", 'R');
        morseToEnglishMap.put("...", 'S');
        morseToEnglishMap.put("-", 'T');
        morseToEnglishMap.put("..-", 'U');
        morseToEnglishMap.put("...-", 'V');
        morseToEnglishMap.put(".--", 'W');
        morseToEnglishMap.put("-..-", 'X');
        morseToEnglishMap.put("-.--", 'Y');
        morseToEnglishMap.put("--..", 'Z');

        for (char key : englishToMorseMap.keySet()) {
            morseToEnglishMap.put(englishToMorseMap.get(key), key);
        }
    }

    public static String convertToMorse(String englishText) {
        StringBuilder morseCode = new StringBuilder();
        for (char character : englishText.toUpperCase().toCharArray()) {
            if (character == ' ') {
                morseCode.append(" ");
            } else {
                String morseValue = englishToMorseMap.get(Character.toUpperCase(character));
                if (morseValue == null) {
                    throw new IllegalArgumentException();
                }
                morseCode.append(morseValue);
                morseCode.append(" ");
            }
        }
        return morseCode.toString().trim();
    }

    public static String convertToEnglish(String morseCode) {
        StringBuilder englishText = new StringBuilder();
        String[] words = morseCode.split("   ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                Character englishValue = morseToEnglishMap.get(letter.toUpperCase());
                if (englishValue == null) {
                    throw new IllegalArgumentException();
                }
                englishText.append(englishValue);
            }
            englishText.append(" ");
        }
        return englishText.toString().trim();
    }
}

 class TextProcessor {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your Morse code: ");
            String morseCodeInput  = input.nextLine();
            String englishText = MorseCodeConverter.convertToEnglish(morseCodeInput);
            System.out.print(englishText);

            System.out.println();

        } catch (Exception e) {
            System.out.println("Error: Invalid Morse code input. Please check your input and try again.");
        }

        try {

            Scanner input2 = new Scanner(System.in);
            System.out.println("Please enter your English code: ");
            String englishLang  = input2.nextLine();
            String morseCode = MorseCodeConverter.convertToMorse(englishLang);
            System.out.print(morseCode);
        } catch (Exception e) {
         System.out.println("Error: Invalid English code input. Please check your input and try again.");
     }
    }
}