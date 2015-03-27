package ru.kpfu.itis.group11408.zakirov.semestrWork1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Anvar on 27.03.2015.
 */
public class HTMLParser {
    Document document;

    public HTMLParser(String url){
        try {
            this.document = Jsoup.connect(url).get();
        }catch(IOException ioE){
            ioE.printStackTrace();
        }
    }
}
