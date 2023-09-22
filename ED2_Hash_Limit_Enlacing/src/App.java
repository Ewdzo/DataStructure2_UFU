import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, String> citiesDivisorHashMap = new HashMap<Integer, String>();
        HashMap<String, String> citiesLimitHashMap = new HashMap<String, String>();
        String path = "C:\\Users\\AgroDavi\\Downloads\\32211BSI038 - UFUMC\\ED2\\Hash\\src\\cidades.txt";

        int divisor = 425;
        int elements = 425;
        
        
        int[] divisionResults = DivisionHash.populateHashMap(citiesDivisorHashMap, path, divisor, elements);
        System.out.println("There was a total of " + divisionResults[12] + " collisons.");
        System.out.println("COUNTER  QTY");
        for(int i=0; i<12; i++){
            System.out.println(i+"        "+divisionResults[i]);
        }

        int[] limitHashDivisorResults = LimitHashDivisor.populateHashMap(citiesDivisorHashMap, path, divisor, elements);
        System.out.println("\n\nThere was a total of " + limitHashDivisorResults[12] + " collisons.");
        System.out.println("COUNTER  QTY");
        for(int i=0; i<12; i++){
            System.out.println(i+"        "+limitHashDivisorResults[i]);
        }



        HashMap<String, Integer> limitResults = LimitHash.populateHashMap(citiesLimitHashMap, path, divisor, elements);
        int[] limitFinalResults = {0,0,0,0,0,0,0};
        limitResults.forEach((key, value) -> {
            limitFinalResults[value]++;
            if(value>1){
                limitFinalResults[0] += (value-1);
            };    
        });
        System.out.println("\n\nThere was a total of " + limitFinalResults[0] + " collisons.");
        System.out.println("COUNTER  QTY");
        for(int i=1; i<7; i++){
            System.out.println(i+"        "+limitFinalResults[i]);
        }
    }
}
