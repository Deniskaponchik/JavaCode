package Atomic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consoleReader1 = new ReaderThread();
        ReaderThread consoleReader2 = new ReaderThread();
        ReaderThread consoleReader3 = new ReaderThread();

        consoleReader1.start();
        consoleReader2.start();
        consoleReader3.start();

        while (count > readStringCount.get()) {
        }

        consoleReader1.interrupt();
        consoleReader2.interrupt();
        consoleReader3.interrupt();
        System.out.println("#1:" + consoleReader1);
        System.out.println("#2:" + consoleReader2);
        System.out.println("#3:" + consoleReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();

        public void run() {
            //напишите тут ваш код
            //https://ru.stackoverflow.com/questions/732637/java-Как-правильно-использовать-bufferedreader-одновременно-несколькими-потока
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    synchronized (reader) { //1 блок. никто не может войти внутрь блока кода //1, если его уже занял другой поток
                        if (reader.ready()) { //можно ли прочесть что-то из буффера ввода,
                            result.add(reader.readLine()); //2 блок.
                            readStringCount.incrementAndGet();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
