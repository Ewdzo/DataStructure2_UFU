import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LimitHash {
    public static String getHash(String str){
        ArrayList<Integer> ASCII = new ArrayList<Integer>(); 

        for(char ch : str.toCharArray()){ ASCII.add((int)ch); };
        
        Integer finalHash = 0;
        
        for(Integer charCode : ASCII) { 
            String charString = charCode.toString();
            String reverseChar = new StringBuilder(charString).reverse().toString();
            Integer reversedCode = Integer.parseInt(reverseChar);
            
            finalHash += (reversedCode); 
        
        };
        
        return finalHash.toString();
    }

    public static HashMap<String, Integer> populateHashMap(HashMap<String, String> hashMap, String path, int divisor, int counter) throws Exception{
        File file = new File(path);
        HashMap<String, Integer> counterHashMap = new HashMap<String, Integer>();

        try {
            Scanner scanner = new Scanner(file);
            

            for(int i = 0; i < counter; i++){
                String city = scanner.nextLine();
                String hash = LimitHash.getHash(city);
                hashMap.put(hash, city);
                counterHashMap.merge(hash, 1, (a, b) -> a + b);
            }
            scanner.close();
            
        } catch(Exception e){
            throw e;
        }
        
        return counterHashMap;
    }
}
