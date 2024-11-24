package org.valentine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class StaffScrapper {

    public static void getStaff() {
        String url = "https://cs.pollub.pl/staff/";

        try{
            Document doc = Jsoup.connect(url).get();

            Elements staffDiv = doc.select(".post-content");
            Elements staffArticle = staffDiv.select("article");
            Elements departments = staffArticle.select("h3");

            for (Element department : departments) {
                System.out.println(department.text());

                Element sibling = department.nextElementSibling();
                while (sibling != null && sibling.tagName().equals("p")) {
                    sibling.select("a").forEach(a -> System.out.println("\t->" + a.text()));
                    sibling = sibling.nextElementSibling();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
