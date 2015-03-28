package ru.kpfu.itis.group11408.zakirov.semestrWork1;



import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Anvar on 27.03.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        int newsLimit = 5;

        PikabuParser pikabuParser = new PikabuParser();

        while (newsLimit > 0){
            PikabuStory story = pikabuParser.getNextStory();
            if (story == null || story.getRating() < 100)
                continue;
            System.out.println();
            System.out.println("*--*--*--*--*--*--*--*--*--*--*--*");
            System.out.println("Title: " + story.getHeader());
            System.out.println("----------------------------------");
            System.out.println("Author: " + story.getAuthorName());
            System.out.println("----------------------------------");
            System.out.println("Rating: " + story.getRating());
            System.out.println("----------------------------------");
            System.out.println("Story: " + story.getText());
            System.out.println("*--*--*--*--*--*--*--*--*--*--*--*");
            System.out.println();
            newsLimit--;
        }

//        Elements posts = content.getElementsByClass("b-story");
//
//        for (Element post : posts) {
//            for (Element header : post.getElementsByClass("b-story__header-info")){
//                for (Element link : header.getElementsByClass("b-story__link")){
//                    System.out.println(link.text());
//                }
//            }
//        }
    }
}
