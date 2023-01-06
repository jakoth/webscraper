package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/*
    *
    * @author J. Kothari
    *
    * The program imports web data from a website archive and publishes a table
    * with the short forms, names and price values. It also converts prices to doubles
    * and avoids any commas for potential future calculations.
    *
 */
public class Main {

    public static void main(String[] args) {
	final String url= "https://web.archive.org/web/20190104110157/http://shares.telegraph.co.uk/indices/?index=MCX";

        try {
        final Document doc= Jsoup.connect(url).get();
            for(Element row: doc.select("table.tablesorter.full tr")){
            if(row.select("td:nth-of-type(1)").text().equals("")){
                continue;
            } else{
                final String ticker = row.select("td:nth-of-type(1)").text();
                final String name = row.select("td:nth-of-type(2)").text();
                final String tempPrice = row.select("td.right:nth-of-type(3)").text();
                final String newPrice = tempPrice.replace("," , "" );
                final double Price = Double.parseDouble(newPrice);

                System.out.println(ticker + " " + name + " " + Price);
            }
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }



}
