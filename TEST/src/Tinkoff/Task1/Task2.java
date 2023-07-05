package Tinkoff.Task1;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = scanner.nextInt();
        int cut = people / 2;
        int iteration = 0;

        if (cut == 0 || cut == 1) iteration = 0;
        else iteration = 1;


        //while(people/2 > 0 ) {
        while (cut > 0) {
            cut = cut / 2;
            iteration++;
        }
        System.out.println(iteration);
    }
}

    /*
    Пусть F(n) — число разрезов для числа n. F(1) = 0.
    F(2k) = k, потому что можно k раз совмещать все рулеты и резать их пополам.
    F(n) 6 F(n + 1), потому что разрезание рулета на n частей — подзадача от разрезания рулета на n + 1 часть.
    за k разрезов можно получить не больше, чем 2k кусков.
    Совместив полученные знания, получаем, что для n ∈ (2k−1; 2k] ответом будет число k.
    Значит, нужно найти старший бит числа n, что можно сделать с помощью цикла, в котором n будет итеративно делиться на два.
    Число итераций и будет ответом.
    */
