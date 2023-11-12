package zavd1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberVerifier {

    public static void main(String[] args) {
        BufferedReader reader;
        String regExp = "[0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}";

        try {
            reader = new BufferedReader(new FileReader("zavd1_files/file.txt"));
            String line = reader.readLine();

            while (line != null) {
                if(line.matches(regExp)) {
                    System.out.println(line);
                }

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
