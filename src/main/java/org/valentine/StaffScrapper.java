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
            Elements staff = doc.select(".post-content");

            System.out.println(staff.select("h2").text());

            for(Element st : staff){
                String title = st.select("h3").text();
                String workers = st.select("p").text();

                System.out.println(title + "\n");
                System.out.println(workers);
                System.out.println();
            }

        } catch(IOException ex){
            ex.getMessage();
        }
    }

}
