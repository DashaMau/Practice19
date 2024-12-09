import java.util.InputMismatchException;
import java.util.Scanner;

public class InnVerification {


    private static boolean isValidInn(String inn, String fullName) {
        if (inn.length() != 12) return false;
        if (inn.equals("123456789012") && fullName.equals("Иванов Иван Иванович")) return true; //Пример валидного ИНН
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите ФИО: ");
            String fullName = scanner.nextLine();

            System.out.print("Введите ИНН (12 цифр): ");
            String inn = scanner.nextLine();

            if (isValidInn(inn, fullName)) {
                System.out.println("ИНН действителен. Заказ оформлен.");
            } else {
                throw new InvalidInnException("Недействительный ИНН.");
            }

        } catch (InvalidInnException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Ошибка: Некорректный формат ввода.");
        } catch (Exception e) {
            System.err.println("Произошла неизвестная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Определяем пользовательское исключение
class InvalidInnException extends Exception {
    public InvalidInnException(String message) {
        super(message);
    }
}