/**
 * @author Akshay Reddy Kola
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UrinalsTest {

    @Test
    void goodString() {
        System.out.println("====== Akshay Reddy Kola == TEST ONE EXECUTED =======");
        Assertions.assertTrue(Urinals.goodString("10001"));
    }

    @Test
    void checkIfInputStringIsEmpty() {
        System.out.println("====== Akshay Reddy Kola == TEST TWO EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString(""));
    }

    @Test
    void checkIfInputStringContainsInvalidCharacters() {
        System.out.println("====== Akshay Reddy Kola == TEST THREE EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString("@ftq78"));
    }

    @Test
    void checkIfInputFilePathIsCorrectOrNot() {
        System.out.println("====== Akshay Reddy Kola == TEST FOUR EXECUTED =======");
        Assertions.assertThrows(FileNotFoundException.class, () ->Urinals.readInputFile("WrongPath"));
    }
}
