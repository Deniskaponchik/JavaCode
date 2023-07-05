package Tinkoff.Task1;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        if(D>B) {
            sum = A + ((D - B) * C);
        }
        else{
            sum = A;
        }
        System.out.println(sum);
    }

    /*
    A = 100 абонентская плата
    B = 10  мегабайт, включённых в тариф
    C = 12  рублей, каждый мегабайт сверх тарифа
    D = 15  мегабайт планирует потратить
    */
}
