package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class FishProducts {
    private String FishProduct;
    private Double CaloriesHundredGramms;

    public FishProducts() {
    }

    public FishProducts(String milkProduct, Double caloriesHundredGramms) {
        FishProduct = milkProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getMilkProduct() {
        return FishProduct;
    }

    public void setMilkProduct(String milkProduct) {
        FishProduct = milkProduct;
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
                "MilkProduct='" + FishProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
