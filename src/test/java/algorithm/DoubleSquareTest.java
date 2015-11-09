package algorithm;

import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by darya on 08.11.15.
 */
public class DoubleSquareTest {
    @Test
    public void createKeyTest(){
        assertThat(DoubleSquare.makeKey("milki")).containsExactly('m', 'i', 'l', 'k');
    }
    @Test
    public void createTableTest(){
        String str = "АБВГДИКОПРС_";
        assertThat(DoubleSquare.createTable(DoubleSquare.makeKey("ПИВО"),str)).containsExactly(new char[][]{{'П','И','В','О'},{'А','Б','Г','Д'},{'К','Р','С','_'}});
    }
    @Test
    public void encodeLettersTest(){
        String str = "АБВГДИКОПРС_";
        char[][] table1 = DoubleSquare.createTable(DoubleSquare.makeKey("ПИВО"), str);
        char[][] table2 = DoubleSquare.createTable(DoubleSquare.makeKey("ГОРОД"), str);
        assertThat(DoubleSquare.encodeLetters('Р','Д',table1,table2)).containsExactly('_','И');
        assertThat(DoubleSquare.encodeLetters('В','В',table1,table2)).containsExactly('Р','Г');
        assertThat(DoubleSquare.encodeLetters('П','О',table1,table2)).containsExactly('Г','И');

    }
}