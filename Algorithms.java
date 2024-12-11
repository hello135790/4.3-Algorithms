import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        int two_Letters = two_Letters();
        int longest_Word = longest_Word();
        int appears = appears(longest_Word);
        int palindromes = palindromes();
        System.out.println(two_Letters);
        System.out.println(appears);
        System.out.println(palindromes);
        s.close();
    }

    public static int two_Letters() throws FileNotFoundException{
        s = new Scanner(f);
        int two_Letters = 0;
        while (s.hasNext()) {
            if (s.next().length() == 2)
                two_Letters++;
        }
        return two_Letters;
    }

    public static int longest_Word() throws FileNotFoundException{
        s = new Scanner(f);
        String longest_Word = "";
        String current;
  
        while (s.hasNext()) {
            current = s.next();
            if (current.length() > longest_Word.length()) {
                longest_Word = current;
            }
        }
        return longest_Word.length();
    }

    public static int appears(int longest_Word) throws FileNotFoundException{
        s = new Scanner(f);
        int num = 0;
        int length = longest_Word;
  
        while (s.hasNext()) {
            if (s.next().length() == length) {
                num++;
            }
        }
        return num;
    }

    public static int palindromes() throws FileNotFoundException{
        s = new Scanner(f);
        int count = 0;
        int len = 0; 
        int tally = 0;
        String now;
        boolean truth = false;

        while (s.hasNext()) {
            now = s.next();
            len = now.length();
            if (len == 1) count++;
            if (len >= 2)
                for(int i=0; i<len/2; i++) {
                    if (now.substring(i, i+1).equals(now.substring((len-i)-1,len-i))) tally++;
                }
                if (tally == len/2) count++;
        }
        return count;
    }
}