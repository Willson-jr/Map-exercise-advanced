import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Article {
    private String name;
    private Integer price;
    private Double margin;

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", margin=" + margin +
                '}';
    }

    public static void main(String[] args) {
        List<Article> articleList = new ArrayList<>();
        articleList.add(new Article("Shower Gel", 3, 0.6));
        articleList.add(new Article("Board Game", 20, 1.3));
        articleList.add(new Article("Bicycle", 250, 0.8));
        articleList.add(new Article("Strawberries", 10, 0.5));

        Float[] discounts = {0f, 0.1f, 0.15f, 0.25f };




        for (int i = 0; i < discounts.length ; i++) {

            double priceWithDisc = sumOfList(articleList)-sumOfList(articleList)*discounts[i];
            System.out.print("Articles' price after ");
            System.out.printf("%.2f",discounts[i]*100);
            System.out.print("% discount: ");
            System.out.printf("%.2f",priceWithDisc);
            System.out.println();
        }
    }

    public static Double sumOfList (List<Article> list){
        double sum = 0.00;
        for (Article article : list) {
            double articlePrice = article.getPrice()+article.getPrice()*article.getMargin();

            sum += articlePrice;
        }
        return sum;
    }


}
