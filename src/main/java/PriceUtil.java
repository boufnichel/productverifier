
/**
 * Price utility
 *
 * Created by moboufnichel on 22/07/2016.
 */
public final class PriceUtil {

    private PriceUtil(){
        //
    }

    private static String clean(String priceString){
        priceString = priceString.replaceAll("[^0-9,]", "");
        priceString = priceString.replace(",", ".");

        return priceString;
    }

    public static Number parse(String priceString){
        if(priceString != null && !priceString.isEmpty()){
            priceString = clean(priceString);
            try{
                return Double.parseDouble(priceString);
            } catch (NumberFormatException exception) {
                //TODO - log warning
            }
        }
        return null;
    }
}
