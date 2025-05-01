import java.util.Random;
import java.util.Scanner;



class Main{
    private static int bestGameAttempts = Integer.MAX_VALUE; // Инициализируем максимальным значением
    private static final String RESULT = "RESULT";

public static void main(String[] args) {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int numberToGuess;
    int attempts;
    boolean playAgain = true;

    while (playAgain) {
        numberToGuess = random.nextInt(100) + 1; // Генерация случайного числа от 1 до 100
        attempts = 0; // кол-во попыток, обнуляем с каждой новой игрой
        boolean guess = false; //

        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        while (!guess) {
            System.out.print("Введи свою догадку: ");
            String input = scanner.next(); // вводим строку

            if (input.equalsIgnoreCase(RESULT)) { // при вводе RESULT выводим данные об игре
                System.out.println("Текущее количество попыток: " + attempts);
                if (bestGameAttempts == Integer.MAX_VALUE) {
                    System.out.println("Лучшая игра пока не сыграна.");
                } else {
                    System.out.println("Количество попыток в лучшей игре: " + bestGameAttempts);
                }
                continue; //Переход к следующей итерации цикла while, чтобы игрок мог продолжить игру
            }

            try {
                int guessMy = Integer.parseInt(input);
                attempts++;

                if (guessMy < 1 || guessMy > 100) {
                    System.out.println("Пожалуйста, введи число от 1 до 100.");
                } else if (guessMy < numberToGuess) {
                    System.out.println("Я сам в шоке, но, загаданное Число больше брат ");
                } else if (guessMy > numberToGuess) {
                    System.out.println(" Не ожидал от тебя такого. Загаданное число меньше брат");
                } else {
                    System.out.println("Поздравляю! Ты угадал число " + numberToGuess + " за " + attempts + " попыток.");
                    guess = true;

                    // Обновление лучшей игры
                    if (attempts < bestGameAttempts) {
                        bestGameAttempts = attempts;
                        System.out.println("Новый рекорд! Это лучшая игра.");
                    } else if (attempts == bestGameAttempts) {
                        System.out.println("Повторен рекорд!");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введи целое число или команду RESULT.");
            }
        }

        // Предложение сыграть еще раз
        System.out.print("Хочешь сыграть еще раз? (да/нет): ");
        String playAgainInput = scanner.nextLine();
        playAgain = playAgainInput.equalsIgnoreCase("да");
    }

    System.out.println("Спасибо за игру!");
    scanner.close();
}
} 