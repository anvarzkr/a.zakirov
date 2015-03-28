package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Anvar on 27.03.2015.
 */
public class PikabuParser {
    private Document document;
    private int currentStoryId;
    private PikabuStory currentStory;

    public PikabuParser(){

    }

    public PikabuParser(String url){
        try {
            this.document = Jsoup.connect(url).get();
        }catch(Exception e) {
            System.err.println("Story unavailable: " + url);
            //e.printStackTrace();
        }

    }

    public Document getDocument(){
        return this.document;
    }

    public PikabuStory getNextStory() {
        if (this.currentStoryId == 0)
            this.currentStoryId = getLastStoryId();
        Element story = null;
        try{
            story = new PikabuParser("http://pikabu.ru/story/_" + currentStoryId).document.getElementById("inner_wrap_" + this.currentStoryId--);
        }catch (NullPointerException npe){
            System.out.println("Story not found: http://pikabu.ru/story/_" + currentStoryId + 1);
            return null;
        }

        return (this.currentStory = new PikabuStory(story));
    }

    public int getLastStoryId(){
        int lastStoryId;
        Elements stories = new PikabuParser("http://pikabu.ru/hot").document.getElementById("stories_container").getElementsByClass("b-story");

        try{
            lastStoryId = Integer.parseInt(stories.get(0).attr("data-story-id"));
        }catch(NumberFormatException nfe){
            lastStoryId = 0;
            System.err.println("Sorry, cant get information from Pikabu.ru.");
        }

        if (this.currentStoryId == 0)
            this.currentStoryId = lastStoryId;

        return lastStoryId;
    }
}
