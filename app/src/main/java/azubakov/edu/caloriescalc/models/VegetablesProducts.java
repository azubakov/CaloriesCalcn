package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class VegetablesProducts {
    private String VegetablesProduct;
    private Double CaloriesHundredGramms;

    public VegetablesProducts() {
    }

    public VegetablesProducts(String vegetablesProduct, Double caloriesHundredGramms) {
        VegetablesProduct = vegetablesProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getVegetablesProduct() {
        return VegetablesProduct;
    }

    public void setVegetablesProduct(String vegetablesProduct) {
        VegetablesProduct = vegetablesProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "VegetablesProducts{" +
                "VegetablesProduct='" + VegetablesProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
