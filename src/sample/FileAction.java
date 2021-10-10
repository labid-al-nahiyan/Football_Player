package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAction {
    private static final String INPUT_FILE = "players.txt";

    public static void appendStr(String str) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(INPUT_FILE,true));
        bw.write("\n"+str);
        bw.close();
    }

    public static List<String> readFromFile() {
        List<String> players = new ArrayList();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(INPUT_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line == null) break;

            players.add(line);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }
}
