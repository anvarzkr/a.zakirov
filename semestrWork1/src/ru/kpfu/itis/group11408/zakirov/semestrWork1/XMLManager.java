package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Created by Anvar on 11.04.2015.
 */
public class XMLManager {
    public void out(String fileName, PikabuStory pikabuStory){
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            /*Element rootElement = doc.createElement("stories");
            doc.appendChild(rootElement);*/

            Element storyElement = doc.createElement("story");
            //rootElement.appendChild(storyElement);
            doc.appendChild(storyElement);

            Element title = doc.createElement("title");
            title.appendChild(doc.createTextNode(pikabuStory.getHeader()));
            storyElement.appendChild(title);

            Element text = doc.createElement("text");
            text.appendChild(doc.createTextNode(pikabuStory.getText()));
            storyElement.appendChild(text);

            Element author = doc.createElement("author");
            author.appendChild(doc.createTextNode(pikabuStory.getAuthorName()));
            storyElement.appendChild(author);

            Element rating = doc.createElement("rating");
            rating.appendChild(doc.createTextNode(pikabuStory.getRating()+""));
            storyElement.appendChild(rating);

            String[] comments = pikabuStory.getTopCommentStringArray();
            Element cc = doc.createElement("comments-count");
            cc.appendChild(doc.createTextNode(comments.length+""));
            storyElement.appendChild(cc);
            for(int i = 0; i < comments.length; i++){
                Element comment = doc.createElement("comment");
                comment.appendChild(doc.createTextNode(comments[i]));
                storyElement.appendChild(comment);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("stories/"+(fileName.hashCode())+".xml"));

            transformer.transform(source, result);

            System.out.println("Story saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void load(){
        try {
            for (File file : new File("stories").listFiles()) {
                if (!file.getName().contains(".xml"))
                    continue;
                try {
                    org.jsoup.nodes.Document doc = Jsoup.parse(file, "UTF-8");

                    String title = doc.getElementsByTag("title").text();
                    String text = doc.getElementsByTag("text").text();
                    String author = doc.getElementsByTag("author").text();
                    int rating;
                    try {
                        rating = Integer.parseInt(doc.getElementsByTag("rating").text());
                    }catch (NumberFormatException nFE) {
                        rating = 0;
                    }
                    //int commentsCount = Integer.parseInt(doc.getElementsByTag("comments-count").text());
                    ArrayList<String> commentList = new ArrayList<>();
                    //String[] comments = new String[commentsCount];
                    int j = 0;
                    for (org.jsoup.nodes.Element element : doc.getElementsByTag("comment")) {
                        commentList.add(element.text());
                        //comments[j++] = element.text();
                    }

                    new PikabuStory(title, text, author, rating, commentList).print();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            System.out.println("Sorry, but there was a problem while loading posts.");
            System.out.println("Check if folder 'stories' exists in the main folder");
        }
    }
}
