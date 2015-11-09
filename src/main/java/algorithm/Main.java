package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by darya on 08.11.15.
 */
public class Main {
    static private String read(File in) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scR = new Scanner(in)) {
            while (scR.hasNextLine()) {
                stringBuilder.append(scR.nextLine());
            }
        }
        return stringBuilder.toString();
    }

    static private void write(String text,File in) throws IOException {
        try (FileWriter fileWriter = new FileWriter(in, false)) {
            fileWriter.write(text);
        }
    }
    public static void main(String[] args) throws IOException {
        DoubleSquare dsq = new DoubleSquare();
        File file = new File("input");
        Scanner in  = new Scanner(System.in);
        System.out.println("e - encode; d - decode");
        String next = in.next();
        switch(next){
            case "e":
                write(dsq.encode(read(file), "key678hi", "valuePrivateDasha1993"),file);
                break;
            case "d":
                write(dsq.encode(read(file), "valuePrivateDasha1993", "key678hi"),file);
                break;
            default:
                System.out.println("Bad command");
        }
    }

}
