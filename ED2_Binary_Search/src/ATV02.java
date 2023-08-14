public class ATV02 {
    public static void occurrences(int[] array, int number){
        int appearances = 0;
        int index = 0;

        while(index != 100){
            if(array[index] == number){
                appearances++;
            };

            index++;
        }

        System.out.println("Appearances: " + appearances + "\nVerifications: " + index + "\n");
    }
}
