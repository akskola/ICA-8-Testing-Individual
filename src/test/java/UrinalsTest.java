/**
 * @author Akshay Reddy Kola
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

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
        Assertions.assertEquals(1, Urinals.countUrinals("10001"));
        Assertions.assertEquals(0, Urinals.countUrinals("1001"));
        Assertions.assertEquals(3, Urinals.countUrinals("00000"));
        Assertions.assertEquals(2, Urinals.countUrinals("0000"));
        Assertions.assertEquals(1, Urinals.countUrinals("01000"));
    }

    @Test
    void checkIfInputStringContainsAdjacentOnes() {
        System.out.println("====== Akshay Reddy Kola == TEST NINE EXECUTED =======");
        Assertions.assertEquals(-1, Urinals.countUrinals("10011"));
        Assertions.assertEquals(-1, Urinals.countUrinals("101101"));
        Assertions.assertEquals(-1, Urinals.countUrinals("0011000"));
    }

    void removePreviousFiles() {
        File folder = new File(".");
        List<String> fileNames = Arrays.stream(Objects.requireNonNull(folder.listFiles())).map(File::getName)
                .filter(name -> name.matches("rule.*.txt")).sorted().toList();
        if(!fileNames.isEmpty()){
            fileNames.forEach(fileName -> {
                File file = new File(fileName);
                try {
                    Files.deleteIfExists(file.toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Test
    void checkIfOutputFilesAreCreated() throws IOException {
        System.out.println("====== Akshay Reddy Kola == TEST TEN EXECUTED =======");
        removePreviousFiles();

        List<Integer> intList = Arrays.asList(0, 2, 1);
        Urinals.createOutputFile(intList);

        File fileName = new File("rule.txt");
        Assertions.assertTrue(fileName.exists());
    }

    @Test
    void checkIfDuplicateOutputFilesAreNamedCorrectly() throws IOException {
        System.out.println("====== Akshay Reddy Kola == TEST ELEVEN EXECUTED =======");
        removePreviousFiles();

        List<Integer> intList1 = Arrays.asList(0, 2, 1);
        List<Integer> intList2 = Arrays.asList(0, 0);
        List<Integer> intList3 = Arrays.asList(2, 4, 0, 1, 5, 2, 7);

        Urinals.createOutputFile(intList1);
        Urinals.createOutputFile(intList2);
        Urinals.createOutputFile(intList3);

        File fileName1 = new File("rule.txt");
        File fileName2 = new File("rule1.txt");
        File fileName3 = new File("rule2.txt");

        Assertions.assertTrue(fileName1.exists());
        Assertions.assertTrue(fileName2.exists());
        Assertions.assertTrue(fileName3.exists());
    }

    @Test
    void checkExecuteMethod() throws EmptyFileException, IOException {
        removePreviousFiles();

        Urinals.execute();

        File fileName = new File("rule.txt");
        List<String> expectedOutput = Arrays.asList("1","0","3","2","1");
        List<String> actualOutput = new ArrayList<>();
        Scanner scanner = new Scanner(fileName);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            actualOutput.add(line);
        }

        Assertions.assertEquals(actualOutput, expectedOutput);
    }
}
