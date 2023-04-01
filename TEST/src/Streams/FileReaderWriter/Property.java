package Streams.FileReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("onr", "1");
        FileWriter fw = new FileWriter("my.propeties");
        prop.store(fw, "my comment");

    }

}
