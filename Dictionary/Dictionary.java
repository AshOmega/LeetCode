import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary
{
    static DictNode root = new DictNode("$");
    public static void main(String[] args)
    {
        List<String> words = Stream.of("apple", "banana", "orange").collect(Collectors.toList());
        System.out.println(words);
        process(words);
        boolean exist = isExist(root, "orange");
        boolean oneOff = isOneOff(root, "applx");
        System.out.println("IsFound : " + exist);
        System.out.println("IsFound : " + oneOff);
    }

    /**
     * To check if a word is present in the dictionary
     * @param root - the root node of the dictionary
     * @param word - the word to be searched
     * @return isExist - boolean
     */
    private static boolean isExist(DictNode root, String word)
    {
        DictNode current = root;
        boolean isFound = true;
        for(int i = 0; i < word.length(); i++){
            String letter = String.valueOf(word.charAt(i));
            int letterAscii = word.charAt(i) - 'a';
            if(current.nodes != null && current.nodes[letterAscii].val.equals(letter)){
           //     System.out.println("Found letter : " + letter);
                current = current.nodes[letterAscii];
            }
            else
            {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    /**
     * To check if a word is found, where letters differs by atmost 1 character
     * "apple" and "applx" differ by 1 char, so its a true scenario
     * "apple" and "aplpx" is not true as the ordering is not maintained
     *
     * @param root - the root node of the dictionary
     * @param word - the word to be searched
     * @return isOneOff - boolean
     */
    private static boolean isOneOff(DictNode root, String word)
    {
        DictNode current = root;
        boolean isFound = true;
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            String letter = String.valueOf(word.charAt(i));
            int letterAscii = word.charAt(i) - 'a';
            if(current.nodes != null && current.nodes[letterAscii].val.equals(letter)){
               // System.out.println("Found letter : " + letter);
                current = current.nodes[letterAscii];
            }
            else
            {
                count++;
                if(count > 1)
                {
                    isFound = false;
                    break;
                }
            }
        }
        return isFound;
    }

    private static void process(List<String> words)
    {
        root.nodes = new DictNode[26];
        for(int i = 0; i < 26; i++){
            root.nodes[i] = new DictNode("-");
        }
        words.stream().forEach(Dictionary::addToDict);
    }

    private static void addToDict(String word){
        DictNode current = root;
        for(int i = 0; i < word.length(); i++){

            String letter = String.valueOf(word.charAt(i));
            int letterAscii = word.charAt(i) - 'a';
            if(current.nodes == null)
            {
                current.nodes = new DictNode[26];
                for(int j = 0; j < 26; j++){
                    current.nodes[j] = new DictNode("-");
                }
            }

            if(current.nodes[letterAscii].val.equals("-")){
               // System.out.println("Node for letter " + letter + " is null...Creating new node");
                current.nodes[letterAscii].val = letter;
            }
            else
            {
              //  System.out.println("Node for letter " + letter + " is available...Skipping");
            }
            current = current.nodes[letterAscii];
        }
    }
}

class DictNode{
    String val = null;
    DictNode nodes[] = null;

    public DictNode(String val){
        this.val = val;
        nodes = null;
    }
}
