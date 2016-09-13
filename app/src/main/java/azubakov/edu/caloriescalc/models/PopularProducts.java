package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class PopularProducts {
    private String popularProduct;
    private Double CaloriesHundredGramms;

    public PopularProducts() {
    }

    public PopularProducts(String popularProduct, Double caloriesHundredGramms) {
        this.popularProduct = popularProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getPopularProduct() {
        return popularProduct;
    }

    public void setPopularProduct(String popularProduct) {
        this.popularProduct = popularProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "PopularProducts{" +
                "popularProduct='" + popularProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
