import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by moboufnichel on 21/07/2016.
 */
public class PlpParserTest {

    private final Logger LOGGER = LoggerFactory.getLogger(PlpParserTest.class);

    private PlpParser plpParser;
    private PdpParser pdpParser;
    private String host;
    private int numberTestedPages;
    private String searchToken;

    @Before
    public void setup(){
        plpParser = new PlpParser();
        pdpParser = new PdpParser();
        host = "http://localhost:9001";
        searchToken = "GEWISS";
        numberTestedPages = 1;
    }

    /**
     * Compare price between plp and pdp for product
     * the goal of this test is to be sure that there is no regression after the indexation
     */
    @Test
    public void priceComparaisonBetweenPlpAndPdp(){


       int koCounter = 0;
       String basePlpUrl = host + "/search?q="+searchToken+"%3Apertinence&view=list&page=";

       for(int i=0; i <= numberTestedPages -1 ; i++){
           String plpUrl = basePlpUrl + i;
           LOGGER.info("start analysing plp {}", plpUrl);
           List<ProductData> products = plpParser.getProductsData(plpUrl);
           for(ProductData productData: products){
               try{
                   String productUrl = host + productData.getPdpUri();
                   pdpParser.getProductData(productUrl,productData);
                   assertEquals(productData.getPdpHtPrice(), productData.getPlpHtPrice());
                   assertEquals(productData.getPdpTTCPrice(), productData.getPlpTTCPrice());
               } catch(AssertionFailedError e){
                   koCounter++;
                   LOGGER.error("{} to be checked !", productData);
               } catch(Exception e){
                   LOGGER.warn("problem found when evaluting the product {} : {}", productData, e.getMessage() );
               }
           }
           LOGGER.info("page {} passed, still {} ...", i, (numberTestedPages - i - 1));
       }

       assertEquals("Some product found with different price between pdp & plp !", 0, koCounter);

    }


}
