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
    private boolean isText;
    public boolean onlyText = true;
    public boolean isNotDisplayable;
    private String authorLinkMatch = "(?i).*" + "profile" + ".*";;

    public PikabuStory(Element storyElement) {
        try {
            this.id = Integer.parseInt(storyElement.attr("data-story-id"));
            this.text = storyElement.getElementById("textDiv" + this.id).text();
            this.header = storyElement.getElementsByClass("b-story__header-info").get(0).getElementsByClass("b-story__link").get(0).text();
            this.authorName = storyElement.getElementsByClass("sv_img_next").select("a").get(2).text();
//            Elements elements = storyElement.getElementsByClass("sv_img_next").select("a");
//            for (Element element: elements){
//                System.out.println(element.text());
//            }
            /*for (Element element : storyElement.getElementsByClass("sv_img_next")) {
                System.out.println(element.text());
                if (element.attr("href").matches(this.authorLinkMatch))
                    this.authorName = element.text();
            }*/

            try {
                Element ratingElement = storyElement.getElementById("num_digs" + this.id);
                this.rating = (ratingElement == null) ? 0 : Integer.parseInt(ratingElement.text());
            } catch (NumberFormatException nfr) {
                this.rating = 0;
            }
        }catch (NullPointerException npe){
            this.isNotDisplayable = true;
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
        return this.text;
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
