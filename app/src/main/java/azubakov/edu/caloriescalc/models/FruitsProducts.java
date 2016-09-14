package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class FruitsProducts {
    private String FruitsProduct;
    private Double CaloriesHundredGramms;

    public FruitsProducts() {
    }

    public FruitsProducts(String milkProduct, Double caloriesHundredGramms) {
        FruitsProduct = milkProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getMilkProduct() {
        return FruitsProduct;
    }

    public void setMilkProduct(String milkProduct) {
        FruitsProduct = milkProduct;
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
                "MilkProduct='" + FruitsProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
