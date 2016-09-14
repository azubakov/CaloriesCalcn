package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 20/07/16.
 */
public class DrinkProducts {
    private String DrinkProduct;
    private Double CaloriesHundredGramms;

    public DrinkProducts() {
    }

    public DrinkProducts(String drinkProduct, Double caloriesHundredGramms) {
        DrinkProduct = drinkProduct;
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    public String getDrinkProduct() {
        return DrinkProduct;
    }

    public void setDrinkProduct(String drinkProduct) {
        DrinkProduct = drinkProduct;
    }

    public Double getCaloriesHundredGramms() {
        return CaloriesHundredGramms;
    }

    public void setCaloriesHundredGramms(Double caloriesHundredGramms) {
        CaloriesHundredGramms = caloriesHundredGramms;
    }

    @Override
    public String toString() {
        return "DrinkProducts{" +
                "DrinkProduct='" + DrinkProduct + '\'' +
                ", CaloriesHundredGramms=" + CaloriesHundredGramms +
                '}';
    }
}
