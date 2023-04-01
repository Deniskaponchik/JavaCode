//package com.javarush.task.task18.task1809;
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        //Создаем поток-чтения-байт-из-файла
        //FileInputStream inputStream = new FileInputStream("D:\Work PC\1\Удалить\Java\str1.txt");
        //FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        // Создаем поток-записи-байт-в-файл
        //FileOutputStream outputStream = new FileOutputStream("D:\Work PC\1\Удалить\Java\str2.txt");
        //FileOutputStream outputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        //byte[] buffer = new byte[1000];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        try (FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());) {
            while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
                //прочитать очередной блок байт в переменную buffer и реальное количество в count
                //int count = inputStream.read(buffer);
                //int count = inputStream.read();
                int stackPush = inputStream.read();
                System.out.println(stackPush);
                stack.push(stackPush);

                //outputStream.write(buffer, 0, count);    //записать блок(часть блока) во второй поток
            }
        } //inputStream.close();    //закрываем оба потока. Они больше не нужны.


        //int sizeStack = stack.size();
        System.out.println(stack.toString());

        try (FileOutputStream outputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());) {
            //for (int i = 0; i < stack.size(); i++) {
            while (true) {
                try {
                    //outputStream.write(bytik);    //записать блок(часть блока) во второй поток
                    int stackPop = stack.pop();
                    System.out.println(stackPop);
                    outputStream.write(stackPop);
                } catch (IOException e) {
                    break;
                }
            }
        } //outputStream.close();

    }
}
