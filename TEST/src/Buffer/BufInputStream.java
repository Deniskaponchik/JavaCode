package Buffer;//Чтение из файла с помощью BufferedReader
//https://metanit.com/java/tutorial/6.9.php
import java.io.*;
public class BufInputStream {
    public static void main(String[] args) throws IOException {
        /*
        try {
            //Ввод пути с Клавиатуры
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //String path = reader.readLine();
            //reader.close();
            ////String path = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            String path = "D:/Work PC/1/txt.txt";
            InputStream inStream = new FileInputStream(path);
            BufferedReader bif = new BufferedReader(new InputStreamReader(inStream));
            while (bif.ready()) {
                System.out.println(bif.readLine());
            }
            inStream.close();
            bif.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        } */



        try( BufferedReader br = new BufferedReader(new FileReader("D:/Work PC/1/txt.txt")) ) {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                 System.out.println(s);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }






    }
}
