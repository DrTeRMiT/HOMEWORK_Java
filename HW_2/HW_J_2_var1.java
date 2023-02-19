package HW_2;
import java.util.Scanner;

public class HW_J_2_var1 {
    
    public static void main(String[] args) throws Exception {
        Integer a = inputNumber("Введите число а: ");
        Integer b = inputNumber("Введите число b: ");

        System.out.println(power(a, b));
    }


    // Получение данных от пользователя
    public static int inputNumber(String text) {
        int i;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print(text);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                break;
            } else {
                System.out.println("Вы ввели не целое число");
            }
        }
        return i;
    }

    // Возведение в степень
    public static double power(int value, int powValue) {
        double result = 1;
        if (powValue > 0) {
            for (int i = 1; i <= powValue; i++) {
                result *= value;
            }
            return result;
        } else if (powValue < 0) {
            for (int i = -1; i > powValue; i--) {
                result *= value;
            }
            result = 1 / (result * value);
            return result;
        } else {
            return 1;
        }
    }
    
}
