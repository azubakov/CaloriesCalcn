package azubakov.edu.caloriescalc.models;

/**
 * Created by stud27 on 28/08/16.
 */
public class Nutritionix {

    private String productname;
    private String calories;
    private String fats;

    public Nutritionix() {

    }

    public Nutritionix(String productname, String calories, String fats) {
        this.productname = productname;
        this.calories = calories;
        this.fats = fats;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    @Override
    public String toString() {
        return "Nutritionix{" +
                "productname='" + productname + '\'' +
                ", calories='" + calories + '\'' +
                ", fats='" + fats + '\'' +
                '}';
    }
}
