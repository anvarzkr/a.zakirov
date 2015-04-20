package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Anvar on 07.04.2015.
 */
public class PikabuStoryParser {
    private int id;
    private String header;
    private String text;
    private String authorName;
    private int rating;
    private boolean isNotDisplayable = false;
    private ArrayList<String> topCommentTree = new ArrayList<>();

    public PikabuStoryParser(Element storyElement){
        try {
            Element storyElementPost = storyElement.select("table").get(0);
            this.id = Integer.parseInt(storyElementPost.attr("data-story-id"));
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
                        topCommentTree.add((comment.length() != 0) ? comment : "%An image here%");
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
            this.isNotDisplayable = true;
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getRating() {
        return rating;
    }

    public boolean isNotDisplayable() {
        return isNotDisplayable;
    }

    public ArrayList<String> getTopCommentTree() {
        return topCommentTree;
    }
}
