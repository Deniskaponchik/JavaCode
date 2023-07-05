package Tinkoff.Task1;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String firstString = scanner.nextLine();
        //for(Integer firstString n){                   }
        int employees = scanner.nextInt();
        int time = scanner.nextInt();

        int[] floors = new int[7];
        for(int i=0; i<=6; i++){
            floors[i] = scanner.nextInt();
        }
        /*
        int floor1 = scanner.nextInt();
        int floor2 = scanner.nextInt();
        int floor3 = scanner.nextInt();
        int floor4 = scanner.nextInt();
        int floor5 = scanner.nextInt();
        int floor6 = scanner.nextInt();
        int floor0 = scanner.nextInt();
        int max = Math.max(floor1, floor6);
        int min = Math.min(floor1, floor6);
        */

        int max = Arrays.stream(floors).max().getAsInt();
        int min = Arrays.stream(floors).min().getAsInt();
        int x = floors[floors.length-1];
        int sum = 0;

        //if(этаж уходящего сотрудника - min эл массива > time  или max элемент массива - этаж уходящего сотрудника < time)
        if(x - min > time  || max - floors[0] < time){
            sum = max - min;
        }
        else{
            if(max-x > x-min){
                sum = max - min + max - x;
            }
            else{
                sum = max - min + x - min;
            }
        }

        System.out.println(sum);
    }
}

    /*
    Найдем максимум и минимум во входных данных. Мы знаем, что ответ не меньше чем max − min.
    Если нельзя успеть пройти всех сотрудников за это время,то это значит, что сотрудник успеет уйти.
    Тогда выгоднее всего сразу доехать до его этажа, а потом сделать одну из двух операций —
        либо подняться на самый верх, а потом спуститься вниз,
        либо спуститься на самый низ, а потом подняться наверх.
    Если уезжающий сотрудник был на этаже x, то получившимися формулами будет
        max − min + max − x
        и
        max − min + x − min
    соответственно, осталось только найти минимум из этих двух величин.
    */
