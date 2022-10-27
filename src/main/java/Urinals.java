/**
 * @author Akshay Reddy Kola
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Urinals {

    static String INPUT_PATH = "urinal.dat";

    public static boolean goodString(String str) {
        if(str.length() == 0){
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                return false;
            }
        }
        return true;
    }

    public static List<String> readInputFile(String path) throws FileNotFoundException {
        List<String> inputRow = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.equals("-1")){
                break;
            } else if (!goodString(line)) {
                throw new NumberFormatException();
            }
            else{
                inputRow.add(line);
            }
        }
        return inputRow;
    }
}
