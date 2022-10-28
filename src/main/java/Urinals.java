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
        if(str.length() == 0 || str.length() > 20){
            return false;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                return false;
            }
        }
        return true;
    }

    public static List<String> readInputFile(String path) throws FileNotFoundException, EmptyFileException {
        List<String> inputRow = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!goodString(line)) {
                throw new NumberFormatException();
            }
            else if (line.equals("-1")){
                break;
            }
            else{
                inputRow.add(line);
            }
        }
        scanner.close();
        if(inputRow.isEmpty()){
            throw new EmptyFileException();
        }
        return inputRow;
    }

    public static int countUrinals(List<String> stringList){
        for(String string: stringList){
            if(Urinals.goodString(string)){
                if(string.contains("11")) {
                    return -1;
                }
                if(string.length() == 1) {
                    return string.contains("0") ? 1 : 0;
                }
                int c = 0;
                char[] ur = string.toCharArray();
                if(ur[0] == '0' && ur[1] == '0') {
                    ur[0] = '1';
                    c++;
                }
                for(int i = 1; i < string.length()-1; i++ ) {
                    if(ur[i] == '0' && ur[i-1] == '0' && ur[i+1]== '0') {
                        ur[i] = 1;
                        c++;
                    }
                }
                if(ur[string.length()-1] == '0' && ur[string.length()-2]=='0') {
                    c++;
                }
                return c;
            }
        }
        return 0;
    }
}
