package ru.kpfu.itis.group11408.zakirov.formatter;

import java.io.*;

/**
 * Created by Anvar on 31.03.2015.
 */
public class Formatter {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("codeSample.txt"));

             PrintWriter pw = new PrintWriter(new FileWriter("codeFormatted.txt"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                line = line.replace(" ", "");
                if (line.equals("{"))
                    System.out.print(line);
                else
                    System.out.print(((i++ != 0) ? System.getProperty("line.separator") : "") + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
