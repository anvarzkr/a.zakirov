package ru.kpfu.itis.group11408.zakirov.semestrWork1;

/*

 */

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;

/**
 * Created by Anvar on 27.03.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        int newsLimit = 1000;
        int num;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, choose the manu item(1-3)");
            System.out.println("1 - load existing posts");
            System.out.println("2 - parse pikabu.ru and save in xml");
            System.out.println("3 - exit programm");
            num = scanner.nextInt();
            while (num < 1 || num > 3) {
                System.out.println("Please, choose the manu item(1-3)");
                num = scanner.nextInt();
            }
        }

        switch (num) {
            case 1:
                XMLManager xmlManager = new XMLManager();
                xmlManager.load();
                break;
            case 2:
                System.out.println("Start parsing data.");
                PikabuParser pikabuParser = new PikabuParser();
                PikabuStory story;
                while (newsLimit > 0) {
                    story = pikabuParser.getNextStory();
                    if (story == null || story.isNotDisplayable || story.getRating() < 0)
                        continue;
                    story.print();
                    story.save();
                    newsLimit--;
                }
                break;
            default:
                System.out.println("Shutdowning the programm");
        }
    }
}