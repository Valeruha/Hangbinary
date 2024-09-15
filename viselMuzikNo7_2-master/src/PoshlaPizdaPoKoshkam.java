import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PoshlaPizdaPoKoshkam {
    static int errorShet;
    static final int maxError = 6;
    static List<Character> errorChar; // letters that have already been entered
    static String secretnoeWord;
    static String secretnoeWordWiew;
    static DrawHangman vidViseletci;

    public static void Start() {
        errorShet = 0;
        errorChar = new ArrayList<>();
        if (LibWords.listOfWords.isEmpty()) {
            System.out.println("Список слов пуст. Невозможно начать игру.");
            return;
        }
        secretnoeWord = LibWords.getSlovo().toUpperCase(Locale.ROOT);
        vidViseletci = new DrawHangman();
        secretnoeWordWiew = "*".repeat(secretnoeWord.length());
        boolean igraIdet = true;

        while (igraIdet) {
            vidViseletci.drawHangman(errorShet);
            System.out.println("Загаданное слово:  " + secretnoeWordWiew);
            System.out.println("Ошибки  (" + errorShet + "): " + errorChar);
            System.out.print("Введите букву: ");
            Character inputChar = Main.readInput();

            if (inputChar == null || errorChar.contains(inputChar)) {
                System.out.println("Неправильный ввод или буква уже использована. Попробуйте снова.");
                continue;
            }

            if (secretnoeWord.contains(String.valueOf(inputChar))) {
                char[] maskaWiew = secretnoeWordWiew.toCharArray();
                for (int i = 0; i < secretnoeWord.length(); i++) {
                    if (secretnoeWord.charAt(i) == inputChar) {
                        maskaWiew[i] = inputChar;
                    }
                }
                secretnoeWordWiew = new String(maskaWiew);
                if (!secretnoeWordWiew.contains("*")) {
                    System.out.println("Поздравляю! Вы угадали слово: " + secretnoeWord);
                    igraIdet = false;
                    System.exit(1);
                }
            } else {
                errorChar.add(inputChar);
                errorShet++;
                if (errorShet >= maxError) {
                    vidViseletci.drawHangman(errorShet);
                    System.out.println("Вы проиграли. Загаданное слово было: " + secretnoeWord);
                    igraIdet = false;
                }
            }
        }
    }

    static void exit() {
        System.exit(1);
    }
}