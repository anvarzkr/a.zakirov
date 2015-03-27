package ru.kpfu.itis.group11408.zakirov.semestrWork1;



import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Anvar on 27.03.2015.
 */
public class Launcher {


    public static void main(String[] args) {
        HTMLParser parser = new HTMLParser("http://pikabu.ru/");

        Element content = parser.document.getElementById("stories_container");

        Elements posts = content.getElementsByTag("tbody");
        for (Element post : posts) {
            for (Element header : post.getElementsByClass("b-story__header-info")){
                System.out.println(header.getElementsByClass());
            }

            //String linkHref = posts.attr("href");
            //String linkText = posts.text();
        }
    }
}
