import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DivisionHash {
    public static int getHash(String str, int divisor){
        ArrayList<Integer> ASCII = new ArrayList<Integer>(); 

        for(char ch : str.toCharArray()){ ASCII.add((int)ch); };
        
        int finalHash = 0;
        
        for(Integer charCode : ASCII) { finalHash += (charCode); };
        
        return finalHash % divisor;
    }

    public static int[] populateHashMap(HashMap<Integer, String> hashMap, String path, int divisor, int counter) throws Exception{
        File file = new File(path);
        int[] colissions = new int[divisor];
        int[] results = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        try {
            Scanner scanner = new Scanner(file);

            for(int i = 0; i < counter; i++){
                String city = scanner.nextLine();
                Integer hash = DivisionHash.getHash(city, divisor);
                hashMap.put(hash, city);
                colissions[hash]++;
            }
            scanner.close();
            
            for(int number : colissions){
                if(number > 1) { results[12] += number; }
                results[number]++;
            }
        } catch(Exception e){
            throw e;
        }
        
        return results;
    }
}
