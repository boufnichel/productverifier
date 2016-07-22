/**
 * Product populator
 *
 * Created by moboufnichel on 22/07/2016.
 */
public final class ProductDataPopulator {

    public static ProductData populate(String plpUri, String priceHt, String priceTTC){
        ProductData productData = new ProductData();
        productData.setPdpUri(plpUri);
        productData.setPlpHtPrice(PriceUtil.parse(priceHt));
        productData.setPlpTTCPrice(PriceUtil.parse(priceTTC));

        return productData;
    }
}
