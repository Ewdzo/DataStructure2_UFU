public class ATV04 {
    public static void binaryOccurrences(int[] array, int number){
        int appearances = 0, counter = 0, start = 0, end = (array.length - 1);
        
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
                int i = mid;
                
                while(i != 0 && array[i-1] == number) {
                    i--;
                }

                while(i != 100 && array[i] == number) {
                    appearances++;
                    i++;
                }        
                
                start = end + 1;
            };
        }

        System.out.println("Appearances: " + appearances + "\nVerifications: " + counter + "\n");
    }
}
