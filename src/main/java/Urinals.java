/**
 * @author Akshay Reddy Kola
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Urinals {

    static String INPUT_PATH = "urinal.dat";
    static String OUTPUT_PATH = "sampleOutputFiles/";

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

    public static void createOutputFile(List<Integer> integerList) throws IOException {
        String fileName = "rule.txt";
        File folder = new File(".");
        List<String> fileNames = Arrays.stream(Objects.requireNonNull(folder.listFiles())).map(File::getName)
                .filter(name -> name.matches("rule.*.txt")).sorted().toList();
        if (!fileNames.isEmpty()) {
            String hNum = fileNames.get(fileNames.size() - 1);
            String fileNumber = hNum.substring(4, hNum.length() - 4);
            if (fileNumber.length() > 0) {
                fileName = String.format("rule%d.txt", Integer.parseInt(fileNumber) + 1);
            }
            else {
                fileName = "rule1.txt";
            }
        }
        FileWriter file = new FileWriter(fileName);
        for(Integer x : integerList) {
            file.write(x.toString()+"\n");
        }
        file.close();
    }
}
