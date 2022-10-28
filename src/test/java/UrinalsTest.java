/**
 * @author Akshay Reddy Kola
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class UrinalsTest {

    @Test
    void CheckIfInputStringIsValid() {
        System.out.println("====== Akshay Reddy Kola == TEST ONE EXECUTED =======");
        Assertions.assertTrue(Urinals.goodString("10001"));
        Assertions.assertFalse(Urinals.goodString(""));
        Assertions.assertFalse(Urinals.goodString("10101000101010101011110000010"));
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
        Assertions.assertFalse(Urinals.goodString("@-_=$%a!|"));
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

    @Test
    void checkIfInputFileThrowsEmptyFileException() {
        System.out.println("====== Akshay Reddy Kola == TEST SEVEN EXECUTED =======");
        Assertions.assertThrows(EmptyFileException.class, () -> Urinals.readInputFile("sampleInputFiles/EmptyFileException.dat"));
    }

    @Test
    void checkIfCountUrinalsReturnsExpectedOutput() {
        System.out.println("====== Akshay Reddy Kola == TEST EIGHT EXECUTED =======");
        Assertions.assertEquals(1, Urinals.countUrinals(List.of("10001")));
        Assertions.assertEquals(0, Urinals.countUrinals(List.of("1001")));
        Assertions.assertEquals(3, Urinals.countUrinals(List.of("00000")));
        Assertions.assertEquals(2, Urinals.countUrinals(List.of("0000")));
        Assertions.assertEquals(1, Urinals.countUrinals(List.of("01000")));
    }

    @Test
    void checkIfInputStringContainsAdjacentOnes() {
        System.out.println("====== Akshay Reddy Kola == TEST EIGHT EXECUTED =======");
        Assertions.assertEquals(-1, Urinals.countUrinals(List.of("10011")));
        Assertions.assertEquals(-1, Urinals.countUrinals(List.of("101101")));
        Assertions.assertEquals(-1, Urinals.countUrinals(List.of("0011000")));
    }
}
