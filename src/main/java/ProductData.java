/**
 * Product data pojo
 *
 * Created by moboufnichel on 22/07/2016.
 */
public final class ProductData {

    private String pdpUri;
    private Number plpHtPrice;
    private Number plpTTCPrice;

    private Number pdpHtPrice;
    private Number pdpTTCPrice;

    public String getPdpUri() {
        return pdpUri;
    }

    public void setPdpUri(String pdpUri) {
        this.pdpUri = pdpUri;
    }

    public Number getPlpHtPrice() {
        return plpHtPrice;
    }

    public void setPlpHtPrice(Number plpHtPrice) {
        this.plpHtPrice = plpHtPrice;
    }

    public Number getPlpTTCPrice() {
        return plpTTCPrice;
    }

    public void setPlpTTCPrice(Number plpTTCPrice) {
        this.plpTTCPrice = plpTTCPrice;
    }

    public Number getPdpHtPrice() {
        return pdpHtPrice;
    }

    public void setPdpHtPrice(Number pdpHtPrice) {
        this.pdpHtPrice = pdpHtPrice;
    }

    public Number getPdpTTCPrice() {
        return pdpTTCPrice;
    }

    public void setPdpTTCPrice(Number pdpTTCPrice) {
        this.pdpTTCPrice = pdpTTCPrice;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "pdpUri='" + pdpUri + '\'' +
                ", plpHtPrice=" + plpHtPrice +
                ", plpTTCPrice=" + plpTTCPrice +
                ", pdpHtPrice=" + pdpHtPrice +
                ", pdpTTCPrice=" + pdpTTCPrice +
                '}';
    }
}
