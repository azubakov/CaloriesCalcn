package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class MilkProducts {
    private String MilkProduct;
    private Double CaloriesHundredGramms;

    public MilkProducts() {
    }

    public MilkProducts(String milkProduct, Double caloriesHundredGramms) {
        MilkProduct = milkProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getMilkProduct() {
        return MilkProduct;
    }

    public void setMilkProduct(String milkProduct) {
        MilkProduct = milkProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "MilkProducts{" +
                "MilkProduct='" + MilkProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
