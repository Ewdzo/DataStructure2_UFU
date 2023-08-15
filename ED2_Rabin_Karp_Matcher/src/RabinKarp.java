public class RabinKarp {
   public static String search(String text, String substring, int alphabetSize, int q){

      int subStringLength = substring.length();
      int textLength = text.length();
      int substringHash = 0, textHash = 0;
      int i,j;

      int h = (int) Math.pow(alphabetSize, (subStringLength-1)) % q;

      for(i = 0; i < subStringLength; i++) {
         substringHash = ( ( alphabetSize * substringHash ) + substring.charAt(i) ) % q;
         textHash = ( ( alphabetSize * textHash ) + text.charAt(i))  % q;
      };

      for(i = 0; i <= (textLength - subStringLength); i++) {
         if (substringHash == textHash) {
            for(j = 0; j < subStringLength; j++) {
               if( text.charAt(i+j) != substring.charAt(j) ) break;
      
            }
            
            if (j == subStringLength) return ("Found at index: " + i);

         }

         if (i < (textLength - subStringLength)) {
            textHash = (alphabetSize * (textHash - text.charAt(i) * h) + text.charAt(i + subStringLength)) % q;

            if (textHash < 0) 
               textHash = (textHash + q);
         }
      }

      return " '" + substring + "' Not Found"; 
   }
}
