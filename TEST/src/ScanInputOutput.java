//КОД РАБОЧИЙ !!!

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
public class ScanInputOutput {
    public static void main(String[]args) throws FileNotFoundException {
        //Если путь вводить с консоли
        //Scanner console = new Scanner(System.in);
        //String path = console.nextLine();

        String path = "D:/Work PC/1/txt.txt";
        File file = new File(path);

        Scanner scanner = new Scanner(file);
        //Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        /*
        String path = "c:" +         "\\projects\\log.txt";
        File file = new File();
        Scanner scanner = new Scanner(file);
        String line = scanner.nexLine();
        output.write(1);
        output.close();
         */

    }

}
