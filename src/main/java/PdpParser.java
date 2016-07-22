import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Got product information from pdp using JSoup
 *
 * Created by moboufnichel on 22/07/2016.
 */
public class PdpParser {

    public void getProductData(String host,ProductData product){
        try {
            String pdpUrl = host + product.getPdpUri();
            Document doc = Jsoup.connect(pdpUrl).get();

            Elements newsHeadlines = doc.select("div[class=price_bloc");

            for (Element e : newsHeadlines){
                String htPrice = e.select("p[class=price ht-price]").text();
                String ttcPrice = e.select("p[class=price ttc-price]").text();

                product.setPdpHtPrice(PriceUtil.parse(htPrice));
                product.setPdpTTCPrice(PriceUtil.parse(ttcPrice));

            }
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
