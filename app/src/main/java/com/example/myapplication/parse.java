package com.example.myapplication;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;


public class parse {
    static void parsing() throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Document doc = null;
        try {
            doc = Jsoup.connect("https://vk.com/memzavod1523l").maxBodySize(0).get();
            Elements listNews = doc.body().select(".wall_text");
            for (Element element : listNews) {
                System.out.println(element.text());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
