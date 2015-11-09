package algorithm;

import com.google.common.primitives.Chars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by darya on 08.11.15.
 */
public class DoubleSquare {

    public final static String characters = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?!:;-%*()+=%{}@#<>\u0000";

    private char[][] table(String key) {
        Set<Character> k1 = makeKey(key);
        return createTable(k1, characters);
    }

    static Set<Character> makeKey(String key) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < key.length(); i++) {
            set.add(key.charAt(i));
        }
        return set;
    }

    static char[][] createTable(Set<Character> key, String characters) {
        Set<Character> charactersSet = new LinkedHashSet<>(Chars.asList(characters.toCharArray()));
        charactersSet.removeAll(key);
        Iterator<Character> iteratorKey = key.iterator();
        Iterator<Character> iterator = charactersSet.iterator();
        char[][] table = new char[7][12];
        for (int i = 0; i < 7 + 1; i++)
            for (int j = 0; j < 12; j++) {
                if (iteratorKey.hasNext())
                    table[i][j] = iteratorKey.next();
                else if (iterator.hasNext())
                    table[i][j] = iterator.next();
            }
        return table;
    }

    public String encode(String text, String key1, String key2){
        char[][] table1 = table(key1);
        char[][] table2 = table(key2);
        StringBuilder strBuff = new StringBuilder();
        if (text.length() % 2 != 0)
            text = text + "\u0000";
        for (int i = 0; i < text.length(); i += 2) {
            strBuff.append(encodeLetters(text.charAt(i), text.charAt(i + 1), table1, table2));
        }
        if (strBuff.charAt(strBuff.length() - 1) == '\u0000')
            return strBuff.substring(0, strBuff.length() - 1);
        return strBuff.toString();
    }

    static char[] encodeLetters(char c, char c1, char[][] table1, char[][] table2) {
        int i1 = 0;
        int j1 = 0;
        int i2 = 0;
        int j2 = 0;
        for (int i = 0; i < table1.length; i++)
            for (int j = 0; j < table1[0].length; j++) {
                if (table1[i][j] == c) {
                    i1 = i;
                    j1 = j;
                }
            }
        for (int i = 0; i < table2.length; i++)
            for (int j = 0; j < table2[0].length; j++) {
                if (table2[i][j] == c1) {
                    i2 = i;
                    j2 = j;
                }
            }
        char[] ch = new char[2];
        if (i1 == i2) {
            ch[0] = table2[i1][j1];
            ch[1] = table1[i2][j2];
        } else {
            ch[0] = table2[i1][j2];
            ch[1] = table1[i2][j1];
        }
        return ch;
    }
}
