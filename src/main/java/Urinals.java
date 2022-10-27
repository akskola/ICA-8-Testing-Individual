/**
 * @author Akshay Reddy Kola
 */
import java.io.File;
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

    public static void readInputFile() {
        try{
            File file = new File(INPUT_PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
