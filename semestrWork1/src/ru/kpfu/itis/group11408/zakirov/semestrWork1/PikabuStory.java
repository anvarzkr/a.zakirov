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
    private ArrayList<String> topCommentTree = new ArrayList<>();
    private boolean isNotDisplayable;
    private String authorLinkMatch = "(?i).*" + "profile" + ".*";;

    public PikabuStory(String title, String text, String author, int rating, ArrayList<String> comments) {
        this.header = title;
        this.text = text;
        this.authorName = author;
        this.rating = rating;
        this.topCommentTree = comments;
    }

    public PikabuStory(Element storyElement) {
        PikabuStoryParser pikabuParser = new PikabuStoryParser(storyElement);
        this.id = pikabuParser.getId();
        this.header = pikabuParser.getHeader();
        this.text = pikabuParser.getText();
        this.authorName = pikabuParser.getAuthorName();
        this.rating = pikabuParser.getRating();
        this.topCommentTree = pikabuParser.getTopCommentTree();
        this.isNotDisplayable = pikabuParser.isNotDisplayable();
    }

    public void setNotDisplayable(boolean isNotDisplayable) {
        this.isNotDisplayable = isNotDisplayable;
    }

    public boolean isNotDisplayable() {
        return isNotDisplayable;
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
        //String[] returnString = new String[topCommentTree.size()];
        //int i = 0;
        //nextIndex = 0;
        String[] comments = topCommentTree.toArray(new String[]{});
        return comments;
        //topCommentTree.forEach(str -> {returnString[getNextIndex()] = str;});
        //return returnString;
    }

    public void print(){
        System.out.println();
        System.out.println("*--*--*--*--*--*--*--*--*--*--*--*");
        System.out.println("Title: " + this.getHeader());
        System.out.println("----------------------------------");
        System.out.println("Author: " + this.getAuthorName());
        System.out.println("----------------------------------");
        System.out.println("Rating: " + this.getRating());
        System.out.println("----------------------------------");
        System.out.println("Story: " + this.getText());
        System.out.println("----------------------------------");
        System.out.println("Top Comment Tree:");
        String[] comments = this.getTopCommentStringArray();
        for (int i = 0; i < comments.length; i++){
            for (int j = 0; j <= i; j++)
                System.out.print("-");
            System.out.println(" " + comments[i]);
        }
        System.out.println("*--*--*--*--*--*--*--*--*--*--*--*");
        System.out.println();
    }

    public void save(){
        XMLManager xmlManager = new XMLManager();
        xmlManager.out("pikabu_" + this.getHeader(), this);
    }

}
