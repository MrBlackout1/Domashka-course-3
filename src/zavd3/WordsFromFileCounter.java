package zavd3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordsFromFileCounter {

    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries,
                (e1, e2) -> e2.getValue().compareTo(e1.getValue())
        );

        return sortedEntries;
    }

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

        for (Map.Entry element : entriesSortedByValues(wordsNumbers)) {
            System.out.println(element);
        }
        }

    }
