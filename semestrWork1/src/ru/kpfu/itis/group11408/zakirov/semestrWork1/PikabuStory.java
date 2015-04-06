package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
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
    private ArrayList<String> topCommentTree = new ArrayList<>();
    public boolean onlyText = true;
    public boolean isNotDisplayable;
    private String authorLinkMatch = "(?i).*" + "profile" + ".*";;

    public PikabuStory(Element storyElement) {
        try {
            Element storyElementPost = storyElement.select("table").get(0);
            //System.out.println(storyElementPost.text());
            this.id = Integer.parseInt(storyElementPost.attr("data-story-id"));
            //System.out.println(this.id);
            this.text = storyElementPost.getElementById("textDiv" + this.id).text();
            this.header = storyElementPost.getElementsByClass("b-story__header-info").get(0).getElementsByClass("b-story__link").get(0).text();
            this.authorName = storyElementPost.getElementsByClass("sv_img_next").select("a").get(2).text();
            try {
                Element ratingElement = storyElementPost.getElementById("num_digs" + this.id);
                this.rating = (ratingElement == null) ? 0 : Integer.parseInt(ratingElement.text());
            } catch (NumberFormatException nfr) {
                this.rating = 0;
            }
            try{
                Element commentDiv = storyElement.getElementById("commentsDiv");
                while (true) {
                    try {
                        Element topComment = commentDiv.select("table").get(0);
                        String commentIdString = topComment.getElementsByClass("comm_wrap_counter").get(0).attr("id");
                        int commentId = Integer.parseInt(commentIdString.replaceAll("com", ""));
                        String comment = topComment.getElementById("comment_desc_" + commentId).text();
                        topCommentTree.add(comment);
                        commentDiv = commentDiv.getElementById("comment_toggle_" + commentId);
                    }catch(Exception parseException){
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println("Cant get top comments tree.");
            }

        }catch (NullPointerException npe){
            this.isNotDisplayable = true;
        }catch(IndexOutOfBoundsException ioobe){
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

    public ArrayList<String> getTopCommentTree() {
        return topCommentTree;
    }

    public String[] getTopCommentStringArray(){
        String[] returnString = new String[topCommentTree.size()];
        int i = 0;
        topCommentTree.forEach(str -> {returnString[getNextIndex()] = str;});
        return returnString;
    }

    private int nextIndex = 0;
    private int getNextIndex(){
        return nextIndex++;
    }

    public void parseTopCommentTree() {

    }
}
