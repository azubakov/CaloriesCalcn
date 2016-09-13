package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class MeatProducts {
    private String MeatProduct;
    private Double CaloriesHundredGramms;

    public MeatProducts() {
    }

    public MeatProducts(String milkProduct, Double caloriesHundredGramms) {
        MeatProduct = milkProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getMilkProduct() {
        return MeatProduct;
    }

    public void setMilkProduct(String milkProduct) {
        MeatProduct = milkProduct;
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
                "MilkProduct='" + MeatProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
