import java.util.Scanner;

/*Задача 1:
        Напишите программу, которая запрашивает у пользователя число и проверяет,
        является ли оно положительным. Если число отрицательное или равно нулю,
        программа должна выбрасывать исключение InvalidNumberException с сообщением "Некорректное число".
        В противном случае, программа должна выводить сообщение "Число корректно".*/
public class Task01 {
    public static void main(String[] args) {
        boolean numberIsCorrect;
        do {
            numberIsCorrect = false;
            try {
                inputNumber();
                numberIsCorrect = true;
                System.out.println("Number is correct");
            } catch (InvalidNumberException ex) {
                System.out.println(ex.getMessage());
            }
        } while (!numberIsCorrect);
    }

    public static void inputNumber() throws InvalidNumberException {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input number: ");
        String number = myScanner.nextLine();
        if (number.matches(".*\\d")) {
            if (Integer.parseInt(number) <= 0) {
                throw new InvalidNumberException("Incorrect number");
            }
        } else {
            throw new InvalidNumberException("It isn't a number");
        }
    }
}

class InvalidNumberException extends Exception {
    InvalidNumberException(String message) {
        super(message);
    }
}
