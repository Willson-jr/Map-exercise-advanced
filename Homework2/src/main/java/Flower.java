import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class Flower {
    private String name;
    private Integer height;
    private Boolean flag;


    void grow(int distance) {
        if (height + (6 - distance) < 30) {
            this.height = height + (6 - distance);
        } else {
            this.height = 30;
            this.flag = true;
        }
    }

    static void status(Map<Integer, Flower> list) {
        for (Map.Entry<Integer, Flower> entry : list.entrySet()) {
            System.out.println(entry.getValue().name + " is " + entry.getKey() + " away and its height is " + entry.getValue().height + " --> " + entry.getValue().flag);
        }
    }

    public static void main(String[] args) {
        //1
        Map<Integer, Flower> flowers = new HashMap<>();
        flowers.put(2, (new Flower("Tulip", 0, false)));
        flowers.put(3, (new Flower("Daffodil", 0, false)));
        flowers.put(4, (new Flower("Violet", 0, false)));
        flowers.put(5, (new Flower("Rose", 0, false)));
        //2
        status(flowers);
        //3
        for (int i = 0; i < 9; i++) {
            for (Map.Entry<Integer, Flower> entry : flowers.entrySet()) {
                entry.getValue().grow(entry.getKey());
            }

        }
        status(flowers);
    }
}
