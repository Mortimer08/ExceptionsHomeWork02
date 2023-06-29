import java.util.Scanner;

/*Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
с сообщением "Деление на ноль недопустимо". В противном случае, программа должна выводить результат деления.*/
public class Task02 {
    public static void main(String[] args) {
        try{
            System.out.println(divide());
        }catch (InvalidNumberException ex){
            System.out.println(ex.getMessage());
        }catch (DivisionByZeroException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Integer divide() throws InvalidNumberException, DivisionByZeroException {
        System.out.print("Input first number: ");
        Integer number1 = inputNumber();
        System.out.print("Input second number: ");
        Integer number2 = inputNumber();
        if (number2 == 0) {
            throw new DivisionByZeroException("Divide by zero is impossible");
        }
        return number1 / number2;
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

class DivisionByZeroException extends Exception {
    DivisionByZeroException(String message) {
        super(message);
    }
}