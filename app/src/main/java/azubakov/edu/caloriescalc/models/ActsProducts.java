package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class ActsProducts {
    private String ActsProduct;
    private Double CaloriesHundredGramms;

    public ActsProducts() {
    }

    public ActsProducts(String actsProduct, Double caloriesHundredGramms) {
        ActsProduct = actsProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getActsProduct() {
        return ActsProduct;
    }

    public void setActsProduct(String actsProduct) {
        ActsProduct = actsProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "ActsProducts{" +
                "ActsProduct='" + ActsProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
