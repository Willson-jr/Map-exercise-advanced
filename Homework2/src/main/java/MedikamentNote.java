import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Data
public class MedikamentNote {
    private String name;
    private Integer count;
    private Integer price;

    @Override
    public String toString() {
        return name + ", which costs " + price;
    }

    public static void main(String[] args) {
        Map<Integer, MedikamentNote> grafik = new HashMap<>();

        grafik.put(1, new MedikamentNote("Pyralgine", 2, 12));
        grafik.put(2, new MedikamentNote("Aspirin", 1, 9));
        grafik.put(3, new MedikamentNote("Depakine", 1, 30));
        grafik.put(5, new MedikamentNote("Kodeine", 2, 8));
        grafik.put(10, new MedikamentNote("Novokain", 2, 7));

        System.out.println("Medicaments more expensive than 10:");
        for (Map.Entry<Integer, MedikamentNote> i : grafik.entrySet()) {
            if (i.getValue().price > 10) {
                System.out.println(i.toString());
            }
        }
        System.out.print("Remember to take pills on ");
        String result = grafik.entrySet().stream().map(x -> x.getKey()).map(x -> x.toString()).collect(Collectors.joining(","));
        System.out.println(result);
    }

    public static Integer priceForPills (Map<Integer, MedikamentNote> map){
        Integer sum =0;
        for (Map.Entry<Integer, MedikamentNote> a: map.entrySet()) {
            sum += a.getValue().price * a.getValue().count;
        }
        return sum;
    }
}


