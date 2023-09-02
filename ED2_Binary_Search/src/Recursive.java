
public class Recursive {
    public static void binarySearch(int[] array, int number, int start, int end){  
        if(start == end) {
            System.out.println("Index: NOT FOUND");
            return;
        }      

        
        int mid = start  + ((end - start) / 2);
        System.out.println(array[mid]);

        
        if(array[mid] < number){
            binarySearch(array, number, (mid+1), end);
        }
        else if(array[mid] > number){
            binarySearch(array, number, start, (mid-1));
        }
        else if(array[mid] == number){
            System.out.println("Index: " + mid + "\n");
            return;
        };
    }
}
