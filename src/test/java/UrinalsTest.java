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
    void checkIfInputStringContainsInvalidNumbers() {
        System.out.println("====== Akshay Reddy Kola == TEST THREE EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString("016278"));
    }

    @Test
    void checkIfInputStringContainsOtherInvalidCharacters() {
        System.out.println("====== Akshay Reddy Kola == TEST FOUR EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString("@--==asd!|"));
    }

    @Test
    void checkIfInputFilePathThrowsFileNotFoundException() {
        System.out.println("====== Akshay Reddy Kola == TEST FIVE EXECUTED =======");
        Assertions.assertThrows(FileNotFoundException.class, () -> Urinals.readInputFile("WrongPath"));
    }

    @Test
    void checkIfInputFileThrowsNumberFormatException() {
        System.out.println("====== Akshay Reddy Kola == TEST SIX EXECUTED =======");
        Assertions.assertThrows(NumberFormatException.class, () -> Urinals.readInputFile("sampleInputFiles/NumberFormatException.dat"));
    }
}
