import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class LibWords {
    static Random randomword = new Random();
    static List<String> listOfWords = new ArrayList<>();

    static {
        String put = "fak.txt";
        File failiSBukvami = new File(put);
        try {
            Scanner scanirovanieSlow = new Scanner(failiSBukvami);
            while (scanirovanieSlow.hasNextLine()) {
                String slovo = scanirovanieSlow.nextLine();
                if (slovo.length() > 3) {
                    listOfWords.add(slovo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Чтение из файла наебнулось");
        }
    }

    public static String getSlovo() {
    if (listOfWords.isEmpty()) {
        return null; // или бросить исключение, если необходимо
    }
    return listOfWords.get(randomword.nextInt(listOfWords.size()));
}
}