import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[100], sortedNumbers = new int[100];
        
        for(int i = 0; i<100; i++){
            numbers[i] = (int) Math.round(Math.random() * 100);
            sortedNumbers[i] = numbers[i];
        };
        Arrays.sort(sortedNumbers);


        //ATV01.search(numbers, 100);
        //ATV02.occurrences(numbers, 100);
        //ATV03.binarySearch(sortedNumbers, 100);
        //ATV04.binaryOccurrences(sortedNumbers, 100);


        Recursive.binarySearch(sortedNumbers, 100, 0, (sortedNumbers.length));
    }
}
