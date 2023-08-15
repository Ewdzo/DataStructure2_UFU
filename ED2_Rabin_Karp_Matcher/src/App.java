public class App {
    public static void main(String[] args) throws Exception {
		String text = "O rato roeu a roupa do rei de roma.";
		String[] substrings = {"ro", "rat", " ", "de "};

		System.out.println( RabinKarp.search(text, substrings[0], 256, 101) );


    }
}
