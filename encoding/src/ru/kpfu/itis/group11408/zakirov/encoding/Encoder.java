package ru.kpfu.itis.group11408.zakirov.encoding;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Anvar on 31.03.2015.
 */
public class Encoder {
    public static void main(String[] args) {

        try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("text.txt"), Charset.forName("windows-1251")))){
            pw.println("Привет, текстовый файл в кодировке windows-1251, который читает кирилицу!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReader fr;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("text.txt"), Charset.forName("windows-1251")))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
