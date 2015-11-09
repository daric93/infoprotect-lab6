package algorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by darya on 08.11.15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        DoubleSquare dsq = new DoubleSquare();

        String text = "Hello world! Time: 14:40";
        File file = new File("input");
        String encode = dsq.encode(text, "key678hi", "valuePrivateDasha1993");
        System.out.println('"' + encode + '"');
        System.out.print(dsq.encode(encode, "valuePrivateDasha1993", "key678hi"));
    }

}
