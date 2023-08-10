public class ATV01 {
    public static void search(int[] array, int number){
        int counter = 0;

        while(counter != 100){
            if(array[counter] == number){
                System.out.println("Index: " + counter + "\nVerifications: " + counter + "\n");
                return;
            };

            counter++;
        }

        System.out.println("Index: NOT FOUND" + "\nVerifications: " + counter + "\n");
    }
}
