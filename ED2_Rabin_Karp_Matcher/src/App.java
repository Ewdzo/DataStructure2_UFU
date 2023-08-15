public class App {
    public static void main(String[] args) throws Exception {
		String text = "O rato roeu a roupa do rei de roma.";
		String[] substrings = {"ro", "rat", " ", "de "};

		for(String substring: substrings){
			System.out.println( RabinKarp.search(text, substring, 256, 101) );
		}


    }
}
