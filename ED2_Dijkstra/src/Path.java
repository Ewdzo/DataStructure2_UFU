public class Path {
    int distance;
    String path;

    Path(int distance, String path) {
        this.distance = distance;
        this.path = path;
    }

    public void printPath(){
        String result = "Total Distance: " + distance + " - Path: ";
        char[] pathChar = path.toCharArray();

        for(int i = (pathChar.length - 1); i >= 0; i--) {
            result += pathChar[i] + " ";
        };

        System.out.println(result);
    }
}
