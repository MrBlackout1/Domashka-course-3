package zavd3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsFromFileCounter {

    public static void main(String[] args) {
        BufferedReader reader;
        StringBuilder textToLine = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("zavd3_files/words.txt"));
            String line = reader.readLine();
            while (line != null) {
                textToLine.append(line);
                textToLine.append(" ");
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = textToLine.toString().split(" ");
        Map<String, Integer> wordsNumbers = new HashMap<>();
        for(String word: words){
            if(wordsNumbers.containsKey(word)) {
                int value = wordsNumbers.get(word);
                value = value + 1;
                wordsNumbers.put(word, value);
            }
            else{
                wordsNumbers.put(word, 1);
            }
        }

        System.out.println("Кількість повторювань слів у тексті: ");

        for (Map.Entry<String, Integer> entry : wordsNumbers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
