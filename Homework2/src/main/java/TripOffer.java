import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.*;

@AllArgsConstructor
@Data
public class TripOffer {
    private Float price;
    private Integer nights;
    private String continent;
    private Boolean dog;


    Boolean bookOffer(Float maxPrice, Integer minNights, List<String> Continent, Boolean isThereDog){
        if (getPrice() <= maxPrice && getNights()<= minNights && Continent.contains(getContinent()) && isThereDog == getDog()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        List<TripOffer> offers = new ArrayList<>();
        offers.add(new TripOffer(219.99f, 7, "EU",false));
        offers.add(new TripOffer(349.99f, 10, "SA",true));
        offers.add(new TripOffer(290.99f, 14, "AS",false));
        offers.add(new TripOffer(199.99f, 8, "AF",true));

        String[] first = {"EU","AS","AF"};
        List<String> cont1 = Arrays.asList(first);
        String[] second = {"EU","AS","AF"};
        List<String> cont2 = Arrays.asList(second);
        String[] third = {"EU","AS","AF"};
        List<String> cont3 = Arrays.asList(third);

//        Boolean temp = offers.get(0).bookOffer(200.00f, 6,cont, false);
//        System.out.println(temp);

//        TripOffer want = new TripOffer();
        System.out.println("1");
        for (TripOffer offer : offers) {
            Boolean temp = offer.bookOffer(200.00f, 6,cont1, false);
            if ( temp){
                 System.out.println(offer);
            }
        }
        System.out.println("2");
        for (TripOffer offer : offers) {
            Boolean temp = offer.bookOffer(200.00f, 6,cont2, false);
            if ( temp){
                System.out.println(offer);
            }
        }
        System.out.println("3");
        for (TripOffer offer : offers) {
            Boolean temp = offer.bookOffer(200.00f, 6,cont3, false);
            if ( temp){
                System.out.println(offer);
            }
        }
    }
}
