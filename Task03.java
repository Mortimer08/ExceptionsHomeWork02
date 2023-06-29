import java.util.Scanner;

/*Задача3: - по желанию
Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением
 "Первое число вне допустимого диапазона".
Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением
 "Второе число вне допустимого диапазона".
Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением
 "Сумма первого и второго чисел слишком мала".
Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением
 "Деление на ноль недопустимо".
В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
- необходимо создать 3 класса собвстенных исключений*/
public class Task03 {
    public static void main(String[] args) throws InvalidNumberException, NumberSumException, DivisionByZeroException, NumberOutOfRangeException {
        try {
            multiInput();
        } catch (InvalidNumberException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberOutOfRangeException ex) {
            System.out.println(ex.getMessage());
        } catch (NumberSumException ex) {
            System.out.println(ex.getMessage());
        } catch (DivisionByZeroException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void multiInput() throws InvalidNumberException, NumberOutOfRangeException, NumberSumException, DivisionByZeroException {
        System.out.print("Input first number: ");
        Integer number1 = inputNumber();
        System.out.print("Input second number: ");
        Integer number2 = inputNumber();
        System.out.print("Input third number: ");
        Integer number3 = inputNumber();
        if (number1 > 100) {
            throw new NumberOutOfRangeException("First number is out of range");
        }
        if (number2 < 0) {
            throw new NumberOutOfRangeException("Second number is out of range");
        }
        if (number1 + number2 < 10) {
            throw new NumberSumException("Sum of first and second numbers is to small");
        }
        if (number3 == 0) {
            throw new DivisionByZeroException("Divide by zero is impossible");
        }
        System.out.println("Checking successful");
    }

    public static Integer inputNumber() throws InvalidNumberException {
        Scanner myScanner = new Scanner(System.in);
        String number = myScanner.nextLine();
        if (number.matches(".*\\d")) {
            return Integer.parseInt(number);
        } else {
            throw new InvalidNumberException("It isn't a number");
        }
    }
}

class NumberOutOfRangeException extends Exception {
    NumberOutOfRangeException(String message) {
        super(message);
    }
}

class NumberSumException extends Exception {
    NumberSumException(String message) {
        super(message);
    }

}

