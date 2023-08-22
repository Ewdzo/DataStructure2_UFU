import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Huffman {
   static int alphabetSize = 0;

   public static String encode(String text) {
      char[] textArray = text.toCharArray();
      char[] distinctArray = distinct(text);
      alphabetSize = distinctArray.length;

      int[] frequencies = new int[alphabetSize]; 
      String[] binaryTable = new String[alphabetSize];

      for (int i = 0; i < textArray.length; i++) {
         for(int j = 0; j < alphabetSize; j++) {
            if(textArray[i] == distinctArray[j]) {
               frequencies[j]++;
            }
         }
      }

      Node huffTree = buildTree(distinctArray, frequencies);
      binaryString(binaryTable, huffTree, "");
      String string = "";

      for(int i=0; i<binaryTable.length; i++){
         System.out.println("Char: " + distinctArray[i] + " = " + binaryTable[i]);
      }

      for(char ch : textArray){
         for(int i=0; i < binaryTable.length; i++) {
            if(ch == distinctArray[i]){
               string += binaryTable[i];
            }
         }
      }

      decode(distinctArray, binaryTable, string);
      return string;
   }
   
   static char[] distinct(String str) {
      HashSet<Character> set = new HashSet<Character>();

      for(int i = 0; i < str.length(); i++) { set.add(str.charAt(i)); }

      char[] string = new char[set.size()];
      int i = 0;

      for( char ch : set){
         string[i] = ch;
         i++;
      }
      
      return string;
   };
 
   static Node buildTree(char[] distinctLetters, int[] frequencies) {
      ArrayList<Node> huffTree = new ArrayList<Node>();

      for (char i = 0; i < frequencies.length; i++) {
         if (frequencies[i] > 0) huffTree.add( new Node(distinctLetters[i], frequencies[i], null, null, i) );
      }
   
      while (huffTree.size() > 1) { 
         Node firstNode = huffTree.remove(0);
         Node secondNode = huffTree.remove(0);
         Node parent = new Node('\0', firstNode.frequency + secondNode.frequency, firstNode, secondNode);
         huffTree.add(parent);
         Collections.sort(huffTree);
      }

      return huffTree.remove(0);
   }

   static String[] binaryString(Node root) { 
      String[] string = new String[alphabetSize];
      binaryString(string, root, "");
      return string;
   }
   
   static void binaryString(String[] string, Node node, String s) { 
      if(node.isLeaf()) { 
         string[node.index] = s; 
         return; 
      }

      binaryString(string, node.left, s + '0');
      binaryString(string, node.right, s + '1');
   }

   static void decode(char[] chars, String[] codes, String string) {
      String current = "";
      System.out.print("\nDecoded: ");
      for(char ch : string.toCharArray()){
         current += ch;

         for(int i = 0; i < codes.length; i++){
            if(codes[i].equals(current)) {
               System.out.print(chars[i]);
               current = "";
            }
         }
      }
      System.out.print("\n");
   }

}