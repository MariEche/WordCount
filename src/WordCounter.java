import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class WordCounter{
    public static void main(String[] args) throws Exception{
        String[] words = {"Apple", "apple", "Banana", "banana"};
        Random rand = new Random();
        try(BufferedWriter write = new BufferedWriter(new java.io.FileWriter(("mywords")))){
            for (int i = 0; i < 20; i++){
                write.write(words[rand.nextInt(words.length)] + "\n");
            }
        } 
        
        Map<String, Integer> wordCount = new HashMap();
        try (BufferedReader read = new BufferedReader(new java.io.FileReader("mywords"))){
            String line;
            while((line = read.readLine()) != null){
                line = line.toLowerCase();
                wordCount.put(line, wordCount.getOrDefault(line, 0) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry : wordCount.entrySet()){
            System.err.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}