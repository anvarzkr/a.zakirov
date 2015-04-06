package ru.kpfu.itis.group11408.zakirov.semestrWork1;



import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Anvar on 27.03.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        int newsLimit = 1000;

        PikabuParser pikabuParser = new PikabuParser();
        PikabuStory story;
        while (newsLimit > 0){
            story = pikabuParser.getNextStory();
            if (story == null || story.isNotDisplayable || story.getRating() < 0)
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
            System.out.println("----------------------------------");
            System.out.println("Top Comment Tree:");
            String[] comments = story.getTopCommentStringArray();
            for (int i = 0; i < comments.length; i++){
                for (int j = 0; j <= i; j++)
                    System.out.print("-");
                System.out.println(" " + comments[i]);
            }
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
