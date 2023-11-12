package zavd2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;

public class TxtToJson {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("zavd2_files/file.txt"));
        int pAge;
        String [] splitted;
        String pName;
        sc.nextLine();
        while(sc.hasNext()){
            splitted = sc.nextLine().split(" ");
            pName = splitted[0];
            pAge = Integer.parseInt(splitted[1]);
            Person person = new Person(pName, pAge);
            Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
            String JsonString = gson1.toJson(person);
            FileWriter fw = new FileWriter("zavd2_files/user.json", true);
            fw.write(JsonString);
            fw.flush();
            fw.close();
        }



    }
}
