

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Got product information from plp using JSoup
 *
 * Created by moboufnichel on 21/07/2016.
 */
public class PlpParser {

    public List<ProductData> getProductsData(String urlName){
        List<ProductData> products = new ArrayList<ProductData>();
        try {
            Document doc = Jsoup.connect(urlName).get();

            Elements newsHeadlines = doc.select("div[class=prod_list");

            for (Element e : newsHeadlines){
                String pdpUri = e.getElementsByTag("a").attr("href");

                String plpHtPrice = e.getElementsByTag("div").select("div.price_bloc").select("p[class=price ht-price]").text();
                String plpTtcPrice = e.getElementsByTag("div").select("div.price_bloc").select("p[class=price ttc-price]").text();

                ProductData productData = ProductDataPopulator.populate(pdpUri, plpHtPrice, plpTtcPrice);

                products.add(productData);
            }
        } catch (IOException io){
            io.printStackTrace();
        }

        return products;
    }




}
