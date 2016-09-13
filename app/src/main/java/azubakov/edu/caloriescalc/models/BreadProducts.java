package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class BreadProducts {
    private String breadProduct;
    private Double CaloriesHundredGramms;

    public BreadProducts() {
    }

    public BreadProducts(String breadProduct, Double caloriesHundredGramms) {
        this.breadProduct = breadProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getBreadProduct() {
        return breadProduct;
    }

    public void setBreadProduct(String breadProduct) {
        this.breadProduct = breadProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "BreadProducts{" +
                "breadProduct='" + breadProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
