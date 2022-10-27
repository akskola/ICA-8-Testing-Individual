/**
 * @author Akshay Reddy Kola
 */
public class Urinals {
    public static boolean goodString( String str ) {
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                return false;
            }
        }
        return true;
    }
}
