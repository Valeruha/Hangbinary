import java.util.Scanner;

class Main {
    static Scanner scanirovanie = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            DrawHangman risunok = new DrawHangman();
            System.out.println("ну и шо делать будем? \nчтоб начать новую игру жми 1     чтоб ливнуть напиши 0");
            int vibor = scanirovanie.nextInt();
            if (vibor == 0) {
                System.out.println("Игра завершена!");
                scanirovanie.close();
                break;
            } else if (vibor == 1) {
                PoshlaPizdaPoKoshkam.Start();
            } else {
                System.out.println("что ты ввёл, огузок? введи 1 или 0 ещё раз");
            }
        }
    }

    public static Character readInput() {
        String input = scanirovanie.next();
        if (input.length() > 0) {
            return Character.toUpperCase(input.charAt(0));
        }
        return null;
    }
}
