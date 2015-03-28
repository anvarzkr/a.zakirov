package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.function.Consumer;

/**
 * Created by Anvar on 28.03.2015.
 */
public class PikabuStory {
    private String header;
    private String text;
    private String authorName;
    private int rating;
    private int id;
    private String authorLinkMatch = "(?i).*" + "profile" + ".*";;

    public PikabuStory(Element storyElement) {
        try {
            this.id = Integer.parseInt(storyElement.attr("data-story-id"));
            this.header = storyElement.getElementsByClass("b-story__header-info").get(0).getElementsByClass("b-story__link").get(0).text();
            this.text = storyElement.getElementsByClass("b-story__content").get(0).text();
            for (Element element : storyElement.getElementsByClass("sv_img_next"))
                if (element.attr("href").matches(this.authorLinkMatch))
                    this.authorName = element.text();
            try {
                Element ratingElement = storyElement.getElementById("num_digs" + this.id);
                this.rating = (ratingElement == null) ? 0 : Integer.parseInt(ratingElement.text());
            } catch (NumberFormatException nfr) {
                this.rating = 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
