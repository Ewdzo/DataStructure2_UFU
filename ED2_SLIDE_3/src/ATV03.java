public class ATV03 {
    public static void binarySearch(int[] array, int number){
        int counter = 0, start = 0, end = (array.length - 1);
        
        while(start <= end){
            int mid = start  + ((end - start) / 2);
            
            counter++;

            
            if(array[mid] < number){
                start = mid + 1;
            }
            else if(array[mid] > number){
                end = mid - 1;
            }
            else if(array[mid] == number){
                System.out.println("Index: " + mid + "\nVerifications: " + counter + "\n");
                return;
            };
        }

        System.out.println("Index: NOT FOUND" + "\nVerifications: " + counter + "\n");
    }
}
