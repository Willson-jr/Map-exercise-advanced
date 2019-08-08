import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Bike {
    private Boolean type;
    private Integer widght;
    private Integer days;
    private String color;

    public Bike(Boolean type, Integer widght, String color) {
        this.type = type;
        this.widght = widght;
        this.color = color;
    }

    public static Double orderBike(Boolean bikeType, Integer wheelWidght, String bikeColor, Integer days) {
        int type = 0;
        if (bikeType) type = 1;
        else type = 2;

        int colorPrice = 0;
        if (bikeColor.equalsIgnoreCase("RED")) colorPrice = 500;
        else if ((bikeColor.equalsIgnoreCase("blue"))) colorPrice = 250;
        else if ((bikeColor.equalsIgnoreCase("green"))) colorPrice = 100;

        double price = (days * (type * (colorPrice + wheelWidght / 3.0))) / 20;

        return price;
    }

    public static void main(String[] args) {
        System.out.printf("Ordered for 15 days: (RED, 25, true) -> " +"%.2f",orderBike(true,25,"red",15));
        System.out.println();
        System.out.printf("Ordered for 15 days: (GREEN, 85, false) -> " +"%.2f",orderBike(false,85,"green",40));
        System.out.println();
        System.out.printf("Ordered for 15 days: (BLUE, 43, true) -> " +"%.2f",orderBike(true,43,"blue",20));
        System.out.println();
        Double income = orderBike(true,25,"red",15)
                + orderBike(false,85,"green",40)
                + orderBike(true,43,"blue",20);
        System.out.printf("Rental income:" + "%.2f",income);
    }
}
