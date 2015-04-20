package ru.kpfu.itis.group11408.zakirov.emailFinder;

import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anvar on 14.04.2015.
 */
public class EmailFinder {
    public static void main(String[] args) {
        EmailFinder emailFinder = new EmailFinder();
        emailFinder.findAndPrint("in.txt", "out.txt");
    }

    public void findAndPrint(String fileIn, String fileOut){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileIn));
            BufferedWriter write = new BufferedWriter(new FileWriter(fileOut))){

            String line;
            String template = "(\\w)((\\w)*_*-*\\.*)*(\\w)*@(\\w)((\\w)*_*-*)*(\\w)*(\\.)(\\w)+";
            Pattern pattern;
            Matcher matcher;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                pattern = Pattern.compile(template);
                matcher = pattern.matcher(line);
                while (matcher.find())
                    System.out.println(matcher.group());

//                System.out.println(pattern.pattern());
//                System.out.println(pattern.matcher(line).matches());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
