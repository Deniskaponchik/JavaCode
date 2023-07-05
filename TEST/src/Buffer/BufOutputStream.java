package Buffer;//https://metanit.com/java/tutorial/6.9.php
import java.io.*;
public class BufOutputStream {
    public static void main(String[] args) throws IOException {
        /* РАБОЧЕЕ. Ввод текста с консоли, пока не будет введено exit
        BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
        String path = bufread.readLine();
        //ArrayList<String> strings = new ArrayList<>();
        //FileOutputStream outputStream = new FileOutputStream(path);
        //BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        String stroka;
        while (true) {
            stroka = bufread.readLine();
            //strings.add(stroka);
            bw.write(stroka+"\n");
            if (stroka.equals("exit"))
                break;
        }
        bw.close();
        */

        /*
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Work PC/1/txt.txt"))) {
            String text = "Hello  World!\nHey! Teachers! Leave the kids alone.";
            bw.write(text);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
         */

        //РАБОЧЕЕ. Ввод текста с консоли, пока не будет введено ESC. Запись в файл
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Work PC/1/txt.txt"))) {
            String text;
            while( !(text=br.readLine()).equals("ESC") ){
                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }



    }
}
